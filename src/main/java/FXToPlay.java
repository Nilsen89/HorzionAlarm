package main.java;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class FXToPlay {
	
	private Parent root;
	private Scene scene;
	private FXMLLoader loader;
	private FXToPlayController fxToPlayController;
	
	public FXToPlay(FXApplication app) throws IOException {
		loader = new FXMLLoader(this.getClass().getResource("/main/resources/fxml/toPlay.fxml"));
		fxToPlayController = new FXToPlayController(app);
		loader.setController(fxToPlayController);
		root = loader.load();
		scene = new Scene(root);
	}
	
	public Scene getScene() {
		return scene;
	}
	public FXToPlayController getController() {
		return fxToPlayController;
	}
}