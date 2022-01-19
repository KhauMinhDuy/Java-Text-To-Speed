package com.khauminhduy;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import javazoom.jl.player.Player;

public class App {

	public static void main(String[] args) throws Exception {
		boolean done = textToSound("Xin Chào Quý Khách, Cảm Ơn Quý Khách Đã Mua Hàng");
		if(done) {
			byte[] data = Files.readAllBytes(Paths.get("src/main/resources/hello.mp3"));
			BufferedInputStream bufferedInputStream = new BufferedInputStream(new ByteArrayInputStream(data));
			Player player = new Player(bufferedInputStream);
			player.play();
		}
		
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
