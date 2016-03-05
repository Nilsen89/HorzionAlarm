package main.java;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FXApplication extends Application	 {

	private Scene startpage, alarm, statistics, settings, toPlay, tier;
	private Stage primaryStage;
	private FXStartpage fxStartpage;
	private FXAlarm fxAlarm;
	private FXSettings fxSettings;
	private FXToPlay fxToPlay;
	private FXTier fxTier;
	private FXStatistics fxStatistics;
	
	private UsermapsParser up;
	
	ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
	ArrayList<String> maps = new ArrayList<String>();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		up = new UsermapsParser();
		updateData();

		this.primaryStage = primaryStage;
		primaryStage.initStyle(StageStyle.UTILITY);
		fxStartpage = new FXStartpage(this);
		fxAlarm = new FXAlarm(this);
		fxStatistics = new FXStatistics(this);
		fxSettings = new FXSettings(this);
		fxToPlay = new FXToPlay(this);
		fxTier = new FXTier(this);
		
		startpage = fxStartpage.getScene();
		alarm = fxAlarm.getScene();
		statistics = fxStatistics.getScene();
		settings = fxSettings.getScene();
		toPlay = fxToPlay.getScene();
		tier = fxTier.getScene();
		
		primaryStage.setScene(fxStartpage.getScene());
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	public void updateData() throws FileNotFoundException, IOException {
		up.parseData();
		maps = up.getMaps();
		data = up.getData();
	}	
	public FXToPlay getToPlay() {
		return fxToPlay;
	}
	public void setSceneToStartpage() {
		primaryStage.setScene(startpage);
	}
	public void setSceneToSettings() {
		primaryStage.setScene(settings);
	}
	public void setSceneToAlarm() {
		primaryStage.setScene(alarm);
	}

	public void setSceneToToPlay() {
		primaryStage.setScene(toPlay);
	}
	public void setSceneToStatistic() {
		primaryStage.setScene(statistics);
	}
	public void setSceneToTier() {
		primaryStage.setScene(tier);
		fxTier.getController().startAnimation();
	}
	public static void main(String[] args) {
		launch(args);
	}
	
	public void setData(ArrayList<ArrayList<String>> data) {
		this.data = data;
	}
	public ArrayList<ArrayList<String>> getData() {
		return data;
	}
	public void setMaps(ArrayList<String> maps) {
		this.maps = maps;
	}
	public ArrayList<String> getMaps() {
		return maps;
	}
	
}
