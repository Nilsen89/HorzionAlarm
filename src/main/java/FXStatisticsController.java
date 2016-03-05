package main.java;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;


public class FXStatisticsController implements Initializable {
	
	private FXApplication app;
	
	public FXStatisticsController(FXApplication app) throws IOException {
		this.app = app;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {}
	
	@FXML
	public void goTier() {
		app.setSceneToTier();
	}
	
	@FXML
	public void goBack() {
		app.setSceneToStartpage();
	}
}