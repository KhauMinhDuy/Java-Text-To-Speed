package com.khauminhduy.downloadfile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StreamUtils;

import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Main {
	
	private static final String URL = "https://api.zalo.ai/v1/tts/synthesize";
	private static final String APIKEY = "GvqyYQyjUAqEMQVkKhPSJUKiajkgWzZG";
	private static final String SPEED = "1.2";

	public static void main(String[] args) {
//		genxmon();
//		genprice();
		gencustom("Bia Corona Extra Chai 355ml TH24", "bia_corona_extra");
	}

	private static void gencustom(String content, String dir) {
		try (CloseableHttpClient httpClient = HttpClients.createDefault();) {

			List<NameValuePair> params = new ArrayList<>();
			params.add(new BasicNameValuePair("input", content));
			params.add(new BasicNameValuePair("speed", SPEED));
			params.add(new BasicNameValuePair("encode_type", "1"));

			HttpPost httpPost = new HttpPost(URL);
			httpPost.setHeader("apikey", APIKEY);
			httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
			httpPost.setEntity(new UrlEncodedFormEntity(params, StandardCharsets.UTF_8));

			HttpResponse httpResponse = httpClient.execute(httpPost);

			String body = null;
			HttpEntity entity = httpResponse.getEntity();
			if (entity != null) {
				body = EntityUtils.toString(entity);
			}
			Gson gson = new Gson();
			JsonObject jsonObject = gson.fromJson(body, JsonObject.class);

			int errorCode = jsonObject.get("error_code").getAsInt();
			String errorMessage = jsonObject.get("error_message").getAsString();
			if (errorCode == 0) {
				String url = jsonObject.get("data").getAsJsonObject().get("url").getAsString();
				String inputStream = getInputStream(url);
				if (!inputStream.equals("")) {
					byte[] decode = Base64.getDecoder().decode(inputStream);
					Files.write(decode, new File(dir+".mp3"));
				}
			} else {
				throw new Exception(errorMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void genxmon() {
		for (int i = 22; i <= 50; i++) {
			try (CloseableHttpClient httpClient = HttpClients.createDefault();) {

				List<NameValuePair> params = new ArrayList<>();
				params.add(new BasicNameValuePair("input", "giỏ hàng " + i + " món, tổng tiền"));
				params.add(new BasicNameValuePair("speed", SPEED));
				params.add(new BasicNameValuePair("encode_type", "1"));

				HttpPost httpPost = new HttpPost(URL);
				httpPost.setHeader("apikey", APIKEY);
				httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
				httpPost.setEntity(new UrlEncodedFormEntity(params, StandardCharsets.UTF_8));

				HttpResponse httpResponse = httpClient.execute(httpPost);

				String body = null;
				HttpEntity entity = httpResponse.getEntity();
				if (entity != null) {
					body = EntityUtils.toString(entity);
				}
				Gson gson = new Gson();
				JsonObject jsonObject = gson.fromJson(body, JsonObject.class);

				int errorCode = jsonObject.get("error_code").getAsInt();
				String errorMessage = jsonObject.get("error_message").getAsString();
				if (errorCode == 0) {
					String url = jsonObject.get("data").getAsJsonObject().get("url").getAsString();
					String inputStream = getInputStream(url);
					if (!inputStream.equals("")) {
						byte[] decode = Base64.getDecoder().decode(inputStream);
						Files.write(decode, new File("mon/" + i + "mon.mp3"));
					}
				} else {
					throw new Exception(errorMessage);
				}
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}

	private static void genprice() {
		for (int i = 1891500; i <= 2000000; i = i + 500) {
			try (CloseableHttpClient httpClient = HttpClients.createDefault();) {

				List<NameValuePair> params = new ArrayList<>();
				params.add(new BasicNameValuePair("input", String.valueOf(i)));
				params.add(new BasicNameValuePair("speed", SPEED));
				params.add(new BasicNameValuePair("encode_type", "1"));

				HttpPost httpPost = new HttpPost(URL);
				httpPost.setHeader("apikey", APIKEY);
				httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
				httpPost.setEntity(new UrlEncodedFormEntity(params, StandardCharsets.UTF_8));

				HttpResponse httpResponse = httpClient.execute(httpPost);

				String body = null;
				HttpEntity entity = httpResponse.getEntity();
				if (entity != null) {
					body = EntityUtils.toString(entity);
				}
				Gson gson = new Gson();
				JsonObject jsonObject = gson.fromJson(body, JsonObject.class);

				int errorCode = jsonObject.get("error_code").getAsInt();
				String errorMessage = jsonObject.get("error_message").getAsString();
				if (errorCode == 0) {
					String url = jsonObject.get("data").getAsJsonObject().get("url").getAsString();
					String inputStream = getInputStream(url);
					if (!inputStream.equals("")) {
						byte[] decode = Base64.getDecoder().decode(inputStream);
						Files.write(decode, new File("sotien/" + i + ".mp3"));
					}
				} else {
					throw new Exception(errorMessage);
				}
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public static String getInputStream(String voiceLocation) throws IOException {
		for (int i = 0; i < 100; i++) {
			try {
				URL url = new URL(voiceLocation);
				HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
				urlConn.addRequestProperty("User-Agent",
						"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36");
				InputStream audioSrc = urlConn.getInputStream();
				return Base64.getEncoder().encodeToString(StreamUtils.copyToByteArray(audioSrc));
			} catch (Exception e) {
			}
		}
		return "";
	}

}
