package main.java;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class FXSettings {
	
	private FXMLLoader loader;
	private Scene scene;
	private Parent root;

	public FXSettings(FXApplication app) throws IOException {
		loader = new FXMLLoader(this.getClass().getResource("/main/resources/fxml/settings.fxml"));
		loader.setController(new FXSettingsController(app));
		root = loader.load();
		scene = new Scene(root);
	}
	
	public Scene getScene() {
		return scene;
	}
	
}
