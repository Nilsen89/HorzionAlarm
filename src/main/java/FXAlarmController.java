package main.java;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class FXAlarmController implements Initializable {
	
	@FXML
	private ImageView easyEU, mediumEU, hardEU, beginnerUS, easy1US,easy2US, mediumUS, hardUS, donatorEU, donatorUS;
	@FXML
	private Text errorText;
	
	private FXApplication app;
	private BeepPlayer beeper = new BeepPlayer();
	private Timeline runner;
	private boolean[] checked = new boolean[10];
	
	private ArrayList<String> currentMaps = new ArrayList<String>();
	private ArrayList<String> mapsToPlay = new ArrayList<String>();
	private ArrayList<String> oldMapsToPlay = new ArrayList<String>();
	private ArrayList<String> data = new ArrayList<String>();
	
	private String checkedFilepath = getClass().getResource("/main/resources/images/checked.png").toString();
	private String uncheckedFilepath = this.getClass().getResource("/main/resources/images/unchecked.png").toString();
	
	private Image isChecked = new Image(checkedFilepath);
	private Image unchecked = new Image(uncheckedFilepath);
	
	public FXAlarmController(FXApplication app) throws IOException {
		this.app = app;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {}
	
	private boolean hasChecked() {
		for(int i = 0; i < checked.length; i++) {
			if(checked[i]) {
				return true;
			}
		}
		return false;
	}
	
	@FXML
	public void startAlarm() {
		checkForMaps();
		runner = new Timeline(new KeyFrame(Duration.seconds(300), new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	checkForMaps();
		    }
		}));
		runner.setCycleCount(Timeline.INDEFINITE);
		runner.play();
	}
	
	private void checkForMaps() {
		mapsToPlay.clear();
		data = app.getMaps();
		if(!hasChecked()) {
				errorText.setText("Please check atleast one checkbox");
		} else if(data.size() == 0) {
			errorText.setText("You have no maps played, please go into the settings page");
		} else {
			errorText.setText("Alarm started");
			if(getServerInfo()) {
				for(int i = 0; i < currentMaps.size(); i++) {
					if(!data.contains(currentMaps.get(i).substring(currentMaps.get(i).indexOf("surf_")))) {
						mapsToPlay.add(currentMaps.get(i));
					}
				}
			}
			Collections.copy(oldMapsToPlay, mapsToPlay);
		}
		if(mapsToPlay.size() > 0 && !mapsToPlay.equals(oldMapsToPlay)) {
			hasMapsToPlay();
		}
	}
	
	private void hasMapsToPlay() {
		beeper.playSound();
		app.getToPlay().getController().printResults(mapsToPlay);
		app.setSceneToToPlay();
	}

	private boolean getServerInfo() {
		currentMaps.clear();
		SteamQuery steamQuery = new SteamQuery();
		ServerInfo serverInfo = new ServerInfo();
		
		for(int i = 0; i < serverInfo.getServerSize(); i++) {
			if(checked[i]) {
				String packet = steamQuery.getServerQuery(serverInfo.getServerIP(i), serverInfo.getServerPORT(i));
				currentMaps.add(AnalyzePacket.getMap(packet, serverInfo.getServerName(i)));
			}
		}
		if(currentMaps.size() < 1) {
			errorText.setText("Error: Servers down, or there is an issue getting server info");
			return false;
		}
		return true;
	}
	
	@FXML
	public void stopAlarm() {
		runner.stop();
		errorText.setText("Alarm stoped");
	}
	@FXML
	public void goBack() {
		app.setSceneToStartpage();
	}
	@FXML
	public void goForward() {
		app.setSceneToToPlay();
	}
	
	@FXML
	public void checkedEasyEU() {
		if(!checked[0]) {
			easyEU.setImage(isChecked);
			checked[0] = true;
		} else {
			easyEU.setImage(unchecked);
			checked[0] = false;
		}
	}
	@FXML
	public void checkedMediumEU() {
		if(!checked[1]) {
			mediumEU.setImage(isChecked);
			checked[1] = true;
		} else {
			mediumEU.setImage(unchecked);
			checked[1] = false;
		}
	}
	@FXML
	public void checkedHardEU() {
		if(!checked[2]) {
			hardEU.setImage(isChecked);
			checked[2] = true;
		} else {
			hardEU.setImage(unchecked);
			checked[2] = false;
		}
	}
	@FXML
	public void checkedBeginnerUS() {
		if(!checked[3]) {
			beginnerUS.setImage(isChecked);
			checked[3] = true;
		} else {
			beginnerUS.setImage(unchecked);
			checked[3] = false;
		}
	}
	@FXML
	public void checkedEasy1US() {
		if(!checked[4]) {
			easy1US.setImage(isChecked);
			checked[4] = true;
		} else {
			easy1US.setImage(unchecked);
			checked[4] = false;
		}
	}
	@FXML
	public void checkedEasy2US() {
		if(!checked[5]) {
			easy2US.setImage(isChecked);
			checked[5] = true;
		} else {
			easy2US.setImage(unchecked);
			checked[5] = false;
		}
	}
	@FXML
	public void checkedMediumUS() {
		if(!checked[6]) {
			mediumUS.setImage(isChecked);
			checked[6] = true;
		} else {
			mediumUS.setImage(unchecked);
			checked[6] = false;
		}
	}
	@FXML
	public void checkedHardUS() {
		if(!checked[7]) {
			hardUS.setImage(isChecked);
			checked[7] = true;
		} else {
			hardUS.setImage(unchecked);
			checked[7] = false;
		}
	}
	@FXML
	public void checkedDonatorEU() {
		if(!checked[8]) {
			donatorEU.setImage(isChecked);
			checked[8] = true;
		} else {
			donatorEU.setImage(unchecked);
			checked[8] = false;
		}
	}
	@FXML
	public void checkedDonatorUS() {
		if(!checked[9]) {
			donatorUS.setImage(isChecked);
			checked[9] = true;
		} else {
			donatorUS.setImage(unchecked);
			checked[9] = false;
		}
	}	
}