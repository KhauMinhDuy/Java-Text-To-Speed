package com.khauminhduy;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import com.khauminhduy.consts.Const;

import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

public class App {

	public static void main(String[] args) throws Exception {
//		boolean done = textToSound("Xin Chào Quý Khách");
//		byte[] data = Files.readAllBytes(Paths.get("src/main/resources/hello.mp3"));

		byte[] N_1 = Files.readAllBytes(Paths.get("voice/N_1.mp3"));
		byte[] N_2 = Files.readAllBytes(Paths.get("voice/N_2.mp3"));
		byte[] N_5 = Files.readAllBytes(Paths.get("voice/N_5.mp3"));
		byte[] N_7 = Files.readAllBytes(Paths.get("voice/N_7.mp3"));
		byte[] T_MOT = Files.readAllBytes(Paths.get("voice/T_MOT.mp3"));
		byte[] T_MUOI = Files.readAllBytes(Paths.get("voice/T_MUOI.mp3"));
		byte[] T_NGHIN = Files.readAllBytes(Paths.get("voice/T_NGHIN.mp3"));
		byte[] T_TRAM = Files.readAllBytes(Paths.get("voice/T_TRAM.mp3"));
		byte[] T_TRIEU = Files.readAllBytes(Paths.get("voice/T_TRIEU.mp3"));
		
		List<byte[]> voices = new ArrayList<>();
		voices.add(N_1);
		voices.add(T_TRIEU);
		voices.add(N_7);
		voices.add(T_TRAM);
		voices.add(N_2);
		voices.add(T_MUOI);
		voices.add(T_MOT);
		voices.add(T_NGHIN);
		voices.add(N_5);
		voices.add(T_TRAM);
		
		AdvancedPlayer player;
		BufferedInputStream inputStream;
		for(byte[] voice : voices) {
			inputStream = new BufferedInputStream(new ByteArrayInputStream(voice));
			player = new AdvancedPlayer(inputStream);
			player.play(0, 4);
			
		}
		
//		byte[] decode = Base64.getDecoder().decode(Const.text6);
//		byte[] decode2 = Base64.getDecoder().decode(Const._183000);
//
//		BufferedInputStream bufferedInputStream = new BufferedInputStream(new ByteArrayInputStream(decode));
//		BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new ByteArrayInputStream(decode2));
//		
//		Player player2 = new Player(bufferedInputStream);
//		player2.play();

//		AdvancedPlayer advancedPlayer = new AdvancedPlayer(bufferedInputStream);
//		AdvancedPlayer advancedPlayer2 = new AdvancedPlayer(bufferedInputStream2);
//		advancedPlayer.play();
//		advancedPlayer.setPlayBackListener(new PlaybackListener() {
//
//			@Override
//			public void playbackStarted(PlaybackEvent evt) {
//				// TODO Auto-generated method stub
//				super.playbackStarted(evt);
//			}
//
//			@Override
//			public void playbackFinished(PlaybackEvent evt) {
//				// TODO Auto-generated method stub
//				super.playbackFinished(evt);
//			}
//
//		});

//		advancedPlayer2.play(5, 70);

//		Media media = new Media(new File("src/main/resources/hello.mp3").toURI().toString());
//		MediaPlayer mediaPlayer = new MediaPlayer(media);

//		mediaPlayer.play();
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
