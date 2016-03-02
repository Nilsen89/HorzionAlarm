package main.java;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxStage extends Application{ 
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/main/resources/fxml/horizonAlarm.fxml"));
		loader.setController(new MyController());
		Parent root = loader.load();
	    primaryStage.setScene(new Scene(root));
	    
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}