package main.java;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class FXSettingsController implements Initializable {
	
	@FXML
	private ImageView submitBtn;
	@FXML
	private TextField steamID;
	@FXML
	private Text errorText;
	
	private FXApplication app;
	private String playerID;
	
	public FXSettingsController(FXApplication app) throws IOException {
		this.app = app;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {}
	
	@FXML
	public void submitSteamID() throws IOException {
		if((playerID = steamID.getText()).equals("")) {
			errorText.setText("Please enter a SteamID/CustomURL");
		} else {
			if(ProfileReader.getMaps(playerID)) {
				errorText.setText("Player maps saved");
				app.updateData();
			} else {
				errorText.setText("Error: could not save maps, try another SteamID");
			}
		}
	}
	@FXML
	public void goBack() {
		app.setSceneToStartpage();
	}
}