package com.khauminhduy.labs;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class Main {

	public static void main(String[] args)
			throws IOException, JavaLayerException, UnsupportedAudioFileException, LineUnavailableException {
		byte[] ba = Files.readAllBytes(Paths.get("Archive/ba.mp3"));
		byte[] bay = Files.readAllBytes(Paths.get("Archive/bay.mp3"));
		byte[] bon = Files.readAllBytes(Paths.get("Archive/bon.mp3"));
		byte[] chamCong = Files.readAllBytes(Paths.get("Archive/cham_cong.mp3"));
		byte[] chin = Files.readAllBytes(Paths.get("Archive/chin.mp3"));
		byte[] hai = Files.readAllBytes(Paths.get("Archive/hai.mp3"));
		byte[] khong = Files.readAllBytes(Paths.get("Archive/khong.mp3"));
		byte[] mot = Files.readAllBytes(Paths.get("Archive/mot.mp3"));
		byte[] nam = Files.readAllBytes(Paths.get("Archive/nam.mp3"));
		byte[] sau = Files.readAllBytes(Paths.get("Archive/sau.mp3"));
		byte[] tam = Files.readAllBytes(Paths.get("Archive/tam.mp3"));

		List<byte[]> voices = new ArrayList<>();
		voices.add(mot);
		voices.add(sau);
		voices.add(hai);
		voices.add(bay);
		voices.add(tam);
		
		System.out.println(voices.size());

		BufferedInputStream inputStream = null;
		AdvancedPlayer player = null;
		AudioInputStream audioInputStream;
		Clip clip = AudioSystem.getClip();
		for (byte[] voice : voices) {
			inputStream = new BufferedInputStream(new ByteArrayInputStream(voice));
			
//			audioInputStream = AudioSystem.getAudioInputStream(inputStream);
//			clip.open(audioInputStream);
//			clip.setLoopPoints(0, 5);
			
			player = new AdvancedPlayer(inputStream);
			player.play(0, 13);
		}
		
		voices.clear();
		voices.add(chamCong);
		for (byte[] voice : voices) {
			inputStream = new BufferedInputStream(new ByteArrayInputStream(voice));
			
//			audioInputStream = AudioSystem.getAudioInputStream(inputStream);
//			clip.open(audioInputStream);
//			clip.setLoopPoints(0, 5);
			
			player = new AdvancedPlayer(inputStream);
			player.play(0, 17);
		}
		
		voices.clear();
		voices.add(mot);
		voices.add(hai);
		voices.add(nam);
		voices.add(sau);
		for (byte[] voice : voices) {
			inputStream = new BufferedInputStream(new ByteArrayInputStream(voice));
			
//			audioInputStream = AudioSystem.getAudioInputStream(inputStream);
//			clip.open(audioInputStream);
//			clip.setLoopPoints(0, 5);
			
			player = new AdvancedPlayer(inputStream);
			player.play(0, 13);
		}

		System.out.println("Done");

	}

}
