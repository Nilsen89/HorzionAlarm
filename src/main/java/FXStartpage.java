package main.java;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class FXStartpage {
	
	private Parent root;
	private Scene scene;
	private FXMLLoader loader;
	
	
	public FXStartpage(FXApplication app) throws IOException {
		loader = new FXMLLoader(this.getClass().getResource("/main/resources/fxml/startpage.fxml"));
		loader.setController(new FXStartpageController(app));
		root = loader.load();
		scene = new Scene(root);
	}
	
	public Scene getScene() {
		return scene;
	}
}
