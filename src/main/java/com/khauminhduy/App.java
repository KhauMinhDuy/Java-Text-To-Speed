package com.khauminhduy;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

		byte[] decode = Base64.getDecoder().decode(Const.text2);
		byte[] decode2 = Base64.getDecoder().decode(Const._183000);

		BufferedInputStream bufferedInputStream = new BufferedInputStream(new ByteArrayInputStream(decode));
		BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new ByteArrayInputStream(decode2));

		Player player = new Player(bufferedInputStream);
		player.play();

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
