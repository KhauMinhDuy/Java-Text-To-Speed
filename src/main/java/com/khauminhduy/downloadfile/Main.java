package com.khauminhduy.downloadfile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.apache.commons.io.FileUtils;
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

	public static void main(String[] args) {

		genprice();
//		for (int i = 1; i <= 50; i++) {
//			try (CloseableHttpClient httpClient = HttpClients.createDefault();) {
//
//				List<NameValuePair> params = new ArrayList<>();
//				params.add(new BasicNameValuePair("input", "Giỏ hàng " + i + " món, tổng tiền"));
//				params.add(new BasicNameValuePair("speed", "1.2"));
//				params.add(new BasicNameValuePair("encode_type", "1"));
//
//				HttpPost httpPost = new HttpPost("https://api.zalo.ai/v1/tts/synthesize");
//				httpPost.setHeader("apikey", "GvqyYQyjUAqEMQVkKhPSJUKiajkgWzZG");
//				httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
//				httpPost.setEntity(new UrlEncodedFormEntity(params, StandardCharsets.UTF_8));
//
//				HttpResponse httpResponse = httpClient.execute(httpPost);
//
//				String body = null;
//				HttpEntity entity = httpResponse.getEntity();
//				if (entity != null) {
//					body = EntityUtils.toString(entity);
//				}
//				Gson gson = new Gson();
//				JsonObject jsonObject = gson.fromJson(body, JsonObject.class);
//
//				int errorCode = jsonObject.get("error_code").getAsInt();
//				if (errorCode == 0) {
//					String url = jsonObject.get("data").getAsJsonObject().get("url").getAsString();
//					String inputStream = getInputStream(url);
//					if (!inputStream.equals("")) {
//						byte[] decode = Base64.getDecoder().decode(inputStream);
//						Files.write(decode, new File("voices/giohang_" + i + "_mon.mp3"));
//					}
//				} else {
//					throw new Exception("Limit");
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//				break;
//			}
//		}

	}

	private static void genprice() {
		for (int i = 1899000; i <= 2000000; i = i + 500) {
			try (CloseableHttpClient httpClient = HttpClients.createDefault();) {

				List<NameValuePair> params = new ArrayList<>();
				params.add(new BasicNameValuePair("input", String.valueOf(i)));
				params.add(new BasicNameValuePair("speed", "1.2"));
				params.add(new BasicNameValuePair("encode_type", "1"));

				HttpPost httpPost = new HttpPost("https://api.zalo.ai/v1/tts/synthesize");
				httpPost.setHeader("apikey", "trortfJFigqJQfqx7PWVWhEFfOXKBHaj");
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
				if (errorCode == 0) {
					String url = jsonObject.get("data").getAsJsonObject().get("url").getAsString();
					String inputStream = getInputStream(url);
					if (!inputStream.equals("")) {
						byte[] decode = Base64.getDecoder().decode(inputStream);
						Files.write(decode, new File("voices/" + i + ".mp3"));
					}
				} else {
					throw new Exception("Limit");
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
