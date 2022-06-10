package com.khauminhduy.optimizevoice;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Enumeration;
import java.util.Base64.Decoder;
import java.util.List;

import com.khauminhduy.consts.Const;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class Main {

	public static void main(String[] args) throws JavaLayerException, IOException {
		
//		byte[] bytes1 = Files.readAllBytes(Paths.get("voice1.mp3"));
//		byte[] bytes2 = Files.readAllBytes(Paths.get("voice2.mp3"));
//		byte[] bytes3 = Files.readAllBytes(Paths.get("voice3.mp3"));
//		
//		BufferedInputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(bytes1));
//		AdvancedPlayer player = new AdvancedPlayer(inputStream);
//		
//		BufferedInputStream inputStream2 = new BufferedInputStream(new ByteArrayInputStream(bytes2));
//		AdvancedPlayer player2 = new AdvancedPlayer(inputStream2);
//		
//		BufferedInputStream inputStream3 = new BufferedInputStream(new ByteArrayInputStream(bytes3));
//		AdvancedPlayer player3 = new AdvancedPlayer(inputStream3);
//		
//		player.play();
//		player2.play();
//		player3.play();
		
		
		System.out.println("asdfsd " + 1.0D + " asdfasdf");
	}
	
}
