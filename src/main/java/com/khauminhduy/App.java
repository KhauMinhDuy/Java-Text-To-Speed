package com.khauminhduy;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import com.khauminhduy.consts.Const;

import javazoom.jl.player.advanced.AdvancedPlayer;

public class App {

	public static void main(String[] args) throws Exception {

		byte[] N_1 = Files.readAllBytes(Paths.get("voices_old_1/N_1.mp3"));
		byte[] N_2 = Files.readAllBytes(Paths.get("voices_old_1/N_2.mp3"));
		byte[] N_5 = Files.readAllBytes(Paths.get("voices_old_1/N_5.mp3"));
		byte[] N_6 = Files.readAllBytes(Paths.get("voices_old_1/N_6.mp3"));
		byte[] N_7 = Files.readAllBytes(Paths.get("voices_old_1/N_7.mp3"));
		byte[] T_MOT = Files.readAllBytes(Paths.get("voices_old_1/T_MOT.mp3"));
		byte[] T_MUOI = Files.readAllBytes(Paths.get("voices_old_1/T_MUOI.mp3"));
		byte[] T_MUOIF = Files.readAllBytes(Paths.get("voices_old_1/T_MUOIF.mp3"));
		byte[] T_NGHIN = Files.readAllBytes(Paths.get("voices_old_1/T_NGHIN.mp3"));
		byte[] T_TRAM = Files.readAllBytes(Paths.get("voices_old_1/T_TRAM.mp3"));
		byte[] T_TRIEU = Files.readAllBytes(Paths.get("voices_old_1/T_TRIEU.mp3"));
		byte[] T_TONGTIEN = Files.readAllBytes(Paths.get("voices_old_1/T_TONGTIEN.mp3"));
		byte[] T_KHUYENMAI = Files.readAllBytes(Paths.get("voices_old_1/T_KHUYENMAI.mp3"));

		byte[] biacoronaextra = Files.readAllBytes(Paths.get("voice_result/ProductId_1063021000043-bia_corona_extra_trim.mp3"));
		byte[] mot_thung = Files.readAllBytes(Paths.get("voice_result/1_thung_trim.mp3"));
//		byte[] mot = Files.readAllBytes(Paths.get("voice_result/Quantity_1 (1).mp3"));
//		byte[] thung = Files.readAllBytes(Paths.get("voices/QuantityUnit_5 (thung).mp3"));
		byte[] bon_mot = Files.readAllBytes(Paths.get("voices/4.1.mp3"));
		byte[] kilogam = Files.readAllBytes(Paths.get("voices/kilogam.mp3"));
		byte[] dua_hau = Files.readAllBytes(Paths.get("voices/dua_hau.mp3"));

		List<byte[]> voices = new ArrayList<>();
//		voices.add(N_1);
//		voices.add(T_TRIEU);
//		voices.add(N_7);
//		voices.add(T_TRAM);
//		voices.add(N_2);
//		voices.add(T_MUOI);
//		voices.add(T_MOT);
//		voices.add(T_NGHIN);
//		voices.add(N_5);
//		voices.add(T_TRAM);

//		voices.add(biacoronaextra);
//		voices.add(mot);
//		voices.add(thung);
//		voices.add(mot_thung);
		
		voices.add(dua_hau);
		voices.add(bon_mot);
		voices.add(kilogam);
		
//		voices.add(biacoronaextra);
//		voices.add(mot_thung);

//		byte[] decode = Base64.getDecoder().decode(Const._25mon);
//		BufferedInputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(decode));
//		AdvancedPlayer player = new AdvancedPlayer(inputStream);

		BufferedInputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(voices.get(0)));
		AdvancedPlayer player = new AdvancedPlayer(inputStream);
		player.play();

		inputStream = new BufferedInputStream(new ByteArrayInputStream(voices.get(1)));
		player = new AdvancedPlayer(inputStream);
		player.play();
//		player.play();

		inputStream = new BufferedInputStream(new ByteArrayInputStream(voices.get(2)));
		player = new AdvancedPlayer(inputStream);
		player.play();

//		for (byte[] voice : voices) {
//			inputStream = new BufferedInputStream(new ByteArrayInputStream(voice));
//			player = new AdvancedPlayer(inputStream);
//			player.play();
//		}

	}

	private static boolean textToSound(String text) throws IOException {
		ProcessBuilder processBuilder = new ProcessBuilder("py", "app.py", text);
		processBuilder.redirectErrorStream(true);

		Process process = processBuilder.start();

		InputStream inputStream = process.getInputStream();

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

		List<String> result = bufferedReader.lines().collect(Collectors.toList());

		return result.isEmpty();

	}

}
