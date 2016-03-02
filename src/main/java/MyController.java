package main.java;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class MyController implements Initializable {

	@FXML
	private TextField steamID;
	@FXML
	private CheckBox easyEU, mediumEU, hardEU, donatorEU;
	@FXML
	private CheckBox beginnerUS, easy1US, easy2US, mediumUS, hardUS, donatorUS;
	@FXML
	private Button startAlarmBtn, stopAlarmBtn;
	@FXML
	private Text errorField1, errorField2, intro1, intro2, resultText;
	@FXML
	private GridPane resultTable;
	
	private ArrayList<String> errorsArr = new ArrayList<String>();
	private ArrayList<String> currentMaps = new ArrayList<String>();
	private ArrayList<String> mapToPlay = new ArrayList<String>();
	private ArrayList<String> oldMapToPlay = new ArrayList<String>();
	private ArrayList<CheckBox> checkBoxes = new ArrayList<CheckBox>();
	private ArrayList<String> playerMaps = new ArrayList<String>();;
	
	private Timeline runner;
	private String steamName;
	private boolean[] checkedServers = new boolean[10];
	private boolean hasServer = false;
	
	Media media;
	MediaPlayer mediaPlayer;
	private final String beepPath = this.getClass().getResource("/main/resources/sounds/beep.mp3").toString();
	
	private boolean hasSteamID() {
		if(steamID.getText().equals("")) {
			errorsArr.add("Error: Please enter a SteamID/CustomURL");
			return false;
		}
		steamName = steamID.getText();
		return true;
	}

	private boolean hasCheckedServer() {
		for(int i = 0; i < checkBoxes.size(); i++) {
			if(checkBoxes.get(i).isSelected()) {
				checkedServers[i] = true;
				hasServer = true;
			}
		}
		if(hasServer) {
			return true;
		}
		errorsArr.add("Error: Please check atleast one server");
		return false;
	}
	
	private void clearErrors() {
		errorsArr.clear();
		errorField1.setText("");
		errorField2.setText("");
	}
	
	private void setErrors() {
		errorField1.setText(errorsArr.get(0));
		if(errorsArr.size() > 1) {
			errorField2.setText(errorsArr.get(1));
		}
	}

	private void startAlarm() {
		errorField1.setText("Status: Alarm running");
		mapToPlay.clear();
		for(int mapsIndex = 0; mapsIndex < currentMaps.size(); mapsIndex++) {
			if(!playerMaps.contains(currentMaps.get(mapsIndex).substring(currentMaps.get(mapsIndex).indexOf("surf_")))) {
				mapToPlay.add(currentMaps.get(mapsIndex));
			}
		}
		if(mapToPlay.size() > 0 && !oldMapToPlay.equals(mapToPlay)) {			
			playAlarm();
		}
		oldMapToPlay = mapToPlay;
	}

	private void playAlarm() {
		for(int i = 0; i < mapToPlay.size(); i++) {
			Text text = new Text();
			text.setFill(Color.WHITE);
			text.setText(mapToPlay.get(i));
			resultTable.add(text, 0, i);
		}
		playSound();
	}

	private void playSound() {
		mediaPlayer.play();
	}

	private boolean getPlayerMaps() {
		playerMaps.clone();
		playerMaps = ProfileReader.getMaps(steamName);
		if(playerMaps.size() < 1) {
			errorField1.setText("Error: No maps played found on this account, or there is an issue getting player profile");
			return false;
		}
		return true;
	}

	private boolean getServerInfo() {
		currentMaps.clear();
		SteamQuery steamQuery = new SteamQuery();
		ServerInfo serverInfo = new ServerInfo();
		
		for(int i = 0; i < serverInfo.getServerSize(); i++) {
			if(checkedServers[i]) {
				String packet = steamQuery.getServerQuery(serverInfo.getServerIP(i), serverInfo.getServerPORT(i));
				currentMaps.add(AnalyzePacket.getMap(packet, serverInfo.getServerName(i)));
			}
		}
		if(currentMaps.size() < 1) {
			errorField2.setText("Error: No maps played found on checked servers, or there is an issue getting server info");
			return false;
		}
		return true;
	}
	
	private void startServerChecker() {
		if(getPlayerMaps() && getServerInfo()) {
			startAlarm();
		} else {			
			runner.stop();
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		makePlayer();
		
		intro1.setFill(Color.WHITE);intro2.setFill(Color.WHITE);resultText.setFill(Color.WHITE);
		errorField1.setFill(Color.WHITE);errorField2.setFill(Color.WHITE);
		
		checkBoxes.add(beginnerUS);checkBoxes.add(easy1US);checkBoxes.add(easy2US);checkBoxes.add(mediumUS);checkBoxes.add(hardUS);
		checkBoxes.add(easyEU);checkBoxes.add(mediumEU);checkBoxes.add(hardEU); checkBoxes.add(donatorUS); checkBoxes.add(donatorEU);
		
		stopAlarmBtn.addEventHandler(MouseEvent.MOUSE_CLICKED,
			new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					errorField1.setText("Status: Alarm Stoped");
					runner.stop();
				}
			}
		);
		
		startAlarmBtn.addEventHandler(MouseEvent.MOUSE_CLICKED,
			new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					clearErrors();
					if(hasSteamID() & hasCheckedServer()) {
						startServerChecker();
						runner = new Timeline(new KeyFrame(Duration.seconds(30), new EventHandler<ActionEvent>() {
						    @Override
						    public void handle(ActionEvent event) {
						    	startAlarm();
						    }
						}));
						runner.setCycleCount(Timeline.INDEFINITE);
						runner.play();
					} else {
						setErrors();
					}
				}
			}
		);
	}

	private void makePlayer() {
		media = new Media(beepPath);
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setVolume(0.5);
	}
}