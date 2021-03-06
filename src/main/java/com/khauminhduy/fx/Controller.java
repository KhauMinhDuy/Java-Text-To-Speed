package com.khauminhduy.fx;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import com.khauminhduy.consts.Const;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Controller implements Initializable {

	@FXML
	private Pane pane;

	@FXML
	private Label songLabel;

	@FXML
	private Button playButton;
	
	@FXML
	private Button pauseButton;
	
	@FXML
	private Button resetButton;
	
	@FXML
	private Button previousButton;
	
	@FXML
	private Button nextButton;

	@FXML
	private ComboBox<String> speedBox;

	@FXML
	private Slider volumeSlider;

	@FXML
	private ProgressBar songProgressBar;

	private Media media1;
	private MediaPlayer mediaPlayer1;

	private List<File> songs;
	private int songNumber;
	private int[] speed = { 25, 50, 75, 100, 125, 150, 175, 200 };

	private Timer timer;
	private boolean running;

	byte[] decode = Base64.getDecoder().decode(Const._28mon);
	byte[] decode2 = Base64.getDecoder().decode(Const._183000);

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		songs = new ArrayList<>();
		File directory = new File("music");

		File[] files = directory.listFiles();
		if (files != null) {
			for (File file : files) {
				songs.add(file);
			}
		}

		media1 = new Media(songs.get(songNumber).toURI().toString());
		mediaPlayer1 = new MediaPlayer(media1);

		songLabel.setText(songs.get(songNumber).getName());

		for (int i = 0; i < speed.length; i++) {
			speedBox.getItems().add(String.valueOf(speed[i]));
		}

		speedBox.setOnAction(this::changeSpeed);

		volumeSlider.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue,
				Number newValue) -> mediaPlayer1.setVolume(volumeSlider.getValue() * 0.01));
	}

	public void playMedia() throws InterruptedException {
		beginTimer();
		changeSpeed(null);
		mediaPlayer1.setVolume(volumeSlider.getValue() * 0.01);
		mediaPlayer1.play();
		Duration currentTime = mediaPlayer1.getCurrentTime();
		double seconds = currentTime.toSeconds();
		Thread.sleep((long) seconds);

	}

	public void pauseMedia() {
		cancelTimer();
		mediaPlayer1.pause();
	}

	public void resetMedia() {
		songProgressBar.setProgress(0);
		mediaPlayer1.seek(Duration.seconds(0));
	}

	public void previousMedia() throws InterruptedException {
		if (songNumber > 0) {
			songNumber--;
			mediaPlayer1.stop();

			if (running) {
				cancelTimer();
			}

			media1 = new Media(songs.get(songNumber).toURI().toString());
			mediaPlayer1 = new MediaPlayer(media1);

			songLabel.setText(songs.get(songNumber).getName());

			playMedia();
		} else {
			songNumber = songs.size() - 1;
			mediaPlayer1.stop();

			if (running) {
				cancelTimer();
			}

			media1 = new Media(songs.get(songNumber).toURI().toString());
			mediaPlayer1 = new MediaPlayer(media1);

			songLabel.setText(songs.get(songNumber).getName());

			playMedia();
		}
	}

	public void nextMedia() throws InterruptedException {
		if (songNumber < songs.size() - 1) {
			songNumber++;
			mediaPlayer1.stop();

			if (running) {
				cancelTimer();
			}

			media1 = new Media(songs.get(songNumber).toURI().toString());
			mediaPlayer1 = new MediaPlayer(media1);

			songLabel.setText(songs.get(songNumber).getName());

			playMedia();
		} else {
			songNumber = 0;

			mediaPlayer1.stop();

			if (running) {
				cancelTimer();
			}

			media1 = new Media(songs.get(songNumber).toURI().toString());
			mediaPlayer1 = new MediaPlayer(media1);

			songLabel.setText(songs.get(songNumber).getName());

			playMedia();
		}
	}

	public void changeSpeed(ActionEvent event) {
		if (speedBox.getValue() == null) {
			mediaPlayer1.setRate(1);
		} else {
			mediaPlayer1.setRate(Integer.parseInt(speedBox.getValue()) * 0.01);
		}
	}

	public void beginTimer() {
		timer = new Timer();
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				running = true;
				double seconds = mediaPlayer1.getCurrentTime().toSeconds();
				double end = media1.getDuration().toSeconds();
				songProgressBar.setProgress(seconds / end);
				if (seconds / end == 1) {
					cancelTimer();
				}
			}
		};

		timer.scheduleAtFixedRate(timerTask, 0, 1000);
	}

	public void cancelTimer() {
		running = false;
		timer.cancel();
	}

}
