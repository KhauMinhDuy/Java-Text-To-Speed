package com.khauminhduy.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Base64;
import java.util.List;

import com.khauminhduy.consts.Const;
import com.khauminhduy.consts.Const2;
import com.khauminhduy.consts.Const3;

public class MainClass {
    public static void main(String[] args) throws IOException{
//           new MusicPlayer();
    	
//    	List<String> bytes = Files.readAllLines(Paths.get("output.txt"));
    	
//    	String encodeToString = Base64.getEncoder().encodeToString(bytes);
//    	byte[] decode = Base64.getDecoder().decode(bytes.get(0));
//    	
//    	Path write = Files.write(Paths.get("output2.mp3"), decode, StandardOpenOption.CREATE);
//    	System.out.println(write);
    	
//    	byte[] decode = Base64.getDecoder().decode(Const3.product);
//    	Path write = Files.write(Paths.get("test3.mp3"), decode, StandardOpenOption.CREATE);
//    	System.out.println(write);
    	
    	String encodeToString = Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get("test3.mp3")));
    	System.out.println(encodeToString);
    	
    }
}
