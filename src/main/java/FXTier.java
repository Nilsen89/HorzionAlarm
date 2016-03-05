package main.java;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class FXTier {
	
	private FXMLLoader loader;
	private Scene scene;
	private Parent root;

	public FXTier(FXApplication app) throws IOException {
		loader = new FXMLLoader(this.getClass().getResource("/main/resources/fxml/tiers.fxml"));
		loader.setController(new FXTierController(app));
		root = loader.load();
		scene = new Scene(root);
	}
	
	public Scene getScene() {
		return scene;
	}
	public FXTierController getController() {
		return loader.getController();
	}
	
}
