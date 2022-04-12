package com.khauminhduy.labs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main2 {

	public static void main(String[] args)
			throws LineUnavailableException, UnsupportedAudioFileException, IOException, InterruptedException {
		List<String> voices = new ArrayList<>();
		voices.add("Archive/mot.wav");
		voices.add("Archive/sau.wav");
		voices.add("Archive/hai.wav");
		voices.add("Archive/bay.wav");
		voices.add("Archive/tam.wav");
		voices.add("Archive/tam.wav");
		

		AudioInputStream audioInputStream;
		Clip clip;
		for (String voice : voices) {
			audioInputStream = AudioSystem.getAudioInputStream(new File(voice));
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
//			long microsecondLength = clip.getMicrosecondLength();
//			int x = (int) (microsecondLength / 1000 );
			Thread.sleep(320);
		}
		
		voices.clear();
		voices.add("Archive/cham_cong.wav");
		for (String voice : voices) {
			audioInputStream = AudioSystem.getAudioInputStream(new File(voice));
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
//			long microsecondLength = clip.getMicrosecondLength();
//			int x = (int) (microsecondLength / 1000 );
			Thread.sleep(350);
		}
		
		voices.clear();
		voices.add("Archive/mot.wav");
		voices.add("Archive/hai.wav");
		voices.add("Archive/nam.wav");
		voices.add("Archive/sau.wav");
		for (String voice : voices) {
			audioInputStream = AudioSystem.getAudioInputStream(new File(voice));
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
//			long microsecondLength = clip.getMicrosecondLength();
//			int x = (int) (microsecondLength / 1000 );
			Thread.sleep(320);
		}

	}

}
