package main.java;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BeepPlayer {

	private Media media;
	private MediaPlayer mediaPlayer;
	private final String beepPath = this.getClass().getResource("/main/resources/sounds/beep.mp3").toString();
	
	public BeepPlayer() {
		media = new Media(beepPath);
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setVolume(0.5);
	}
	
	public void playSound() {
		mediaPlayer.play();
	}
	
}