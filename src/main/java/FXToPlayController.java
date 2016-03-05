package main.java;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class FXToPlayController implements Initializable {
	
	@FXML
	private VBox results;
	private FXApplication app;
	
	public FXToPlayController(FXApplication app) throws IOException {
		this.app = app;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {}
	
	public void printResults(ArrayList<String> mapsToPlay) {
		results.getChildren().clear();
		for(int i = 0; i < mapsToPlay.size(); i++) {
			Text text = new Text(mapsToPlay.get(i));
			text.setFill(Color.WHITE);
			text.setStyle("-fx-font-size: 14;");
			results.getChildren().add(text);
		}
	}
	@FXML
	public void goBack() {
		app.setSceneToAlarm();
	}
}