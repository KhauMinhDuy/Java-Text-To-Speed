package com.khauminhduy.google;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import com.google.cloud.texttospeech.v1.AudioConfig;
import com.google.cloud.texttospeech.v1.AudioEncoding;
import com.google.cloud.texttospeech.v1.SsmlVoiceGender;
import com.google.cloud.texttospeech.v1.SynthesisInput;
import com.google.cloud.texttospeech.v1.SynthesizeSpeechResponse;
import com.google.cloud.texttospeech.v1.TextToSpeechClient;
import com.google.cloud.texttospeech.v1.VoiceSelectionParams;
import com.google.protobuf.ByteString;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class QuickstartSample {

	public static void main(String[] args) {
		try {
			TextToSpeechClient textToSpeechClient = TextToSpeechClient.create();
			SynthesisInput input = SynthesisInput.newBuilder().setText("Hello World").build();
			
			VoiceSelectionParams voice = VoiceSelectionParams.newBuilder()
															.setLanguageCode("en-US")
															.setSsmlGender(SsmlVoiceGender.NEUTRAL)
															.build();
			
			AudioConfig audioConfig = AudioConfig.newBuilder().setAudioEncoding(AudioEncoding.MP3).build();
			
			SynthesizeSpeechResponse response = textToSpeechClient.synthesizeSpeech(input, voice, audioConfig);
			
			ByteString audioContents = response.getAudioContent();

			BufferedInputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(audioContents.toByteArray()));
			Player player = new Player(inputStream);
			player.play();
			
		} catch (IOException | JavaLayerException e) {
			e.printStackTrace();
		}
	}
	
}
