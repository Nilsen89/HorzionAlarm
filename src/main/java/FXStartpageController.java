package main.java;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class FXStartpageController implements Initializable {
	
	@FXML
	private ImageView alarmBtn, settingsBtn, statisticsBtn, submitBtn;
	@FXML
	private TextField steamID;
	
	private FXApplication app;
	
	public FXStartpageController(FXApplication app) throws IOException {
		this.app = app;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {}
	
	@FXML
	private void changeToAlarm() {
		app.setSceneToAlarm();
	}
	@FXML
	private void changeToStatistics() {
		app.setSceneToStatistic();
	}
	@FXML
	private void changeToSettings() {
		app.setSceneToSettings();
	}
}