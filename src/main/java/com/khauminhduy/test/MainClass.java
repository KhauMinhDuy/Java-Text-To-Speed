package com.khauminhduy.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Base64;
import java.util.List;

import com.khauminhduy.consts.Const;

public class MainClass {
    public static void main(String[] args) throws IOException{
//           new MusicPlayer();
    	
//    	List<String> bytes = Files.readAllLines(Paths.get("output.txt"));
    	
//    	String encodeToString = Base64.getEncoder().encodeToString(bytes);
//    	byte[] decode = Base64.getDecoder().decode(bytes.get(0));
//    	
//    	Path write = Files.write(Paths.get("output2.mp3"), decode, StandardOpenOption.CREATE);
//    	System.out.println(write);
    	
    	byte[] decode = Base64.getDecoder().decode(Const.productid_8991002306523);
    	Path write = Files.write(Paths.get("test.mp3"), decode, StandardOpenOption.CREATE);
    	System.out.println(write);
    	
    	String encodeToString = Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get("voice_trim/voice.mp3")));
    	System.out.println(encodeToString);
    	
    }
}
