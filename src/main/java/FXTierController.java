package main.java;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Arc;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class FXTierController implements Initializable {
	
	@FXML
	private Arc tier1Arc, tier2Arc, tier3Arc, tier4Arc, tier5Arc, tier6Arc;
	@FXML
	private Text tier1Text, tier2Text, tier3Text, tier4Text, tier5Text, tier6Text;
	
	private double tier1Percent, tier2Percent, tier3Percent, tier4Percent, tier5Percent, tier6Percent;
	
	private FXApplication app;
	private Timeline runner;
	private Statistics statistics;
	
	
	public FXTierController(FXApplication app) throws IOException {
		this.app = app;
		statistics  = new Statistics(app.getData());
	}
	
	public void startAnimation() {
		statistics.calcPercent();
		tier1Percent = Double.parseDouble(statistics.tier1Percent());
		tier2Percent = Double.parseDouble(statistics.tier2Percent());
		tier3Percent = Double.parseDouble(statistics.tier3Percent());
		tier4Percent = Double.parseDouble(statistics.tier4Percent());
		tier5Percent = Double.parseDouble(statistics.tier5Percent());
		tier6Percent = Double.parseDouble(statistics.tier6Percent());

		tier1Text.setText("Tier 1: "+tier1Percent+"%");
		tier2Text.setText("Tier 2: "+tier2Percent+"%");
		tier3Text.setText("Tier 3: "+tier3Percent+"%");
		tier4Text.setText("Tier 4: "+tier4Percent+"%");
		tier5Text.setText("Tier 5: "+tier5Percent+"%");
		tier6Text.setText("Tier 6: "+tier6Percent+"%");
		
		runner = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	if(tier1Arc.getLength() < 361 && tier1Arc.getLength() < tier1Percent*3.6) {		    		
		    		tier1Arc.setLength(tier1Arc.getLength()+1); 
		    	}
		    	if(tier2Arc.getLength() < 361 && tier2Arc.getLength() < tier2Percent*3.6) {		    		
		    		tier2Arc.setLength(tier2Arc.getLength()+1); 
		    	}
		    	if(tier3Arc.getLength() < 361 && tier3Arc.getLength() < tier3Percent*3.6) {		    		
		    		tier3Arc.setLength(tier3Arc.getLength()+1); 
		    	}
		    	if(tier4Arc.getLength() < 361 && tier4Arc.getLength() < tier4Percent*3.6) {		    		
		    		tier4Arc.setLength(tier4Arc.getLength()+1); 
		    	}
		    	if(tier5Arc.getLength() < 361 && tier5Arc.getLength() < tier5Percent*3.6) {		    		
		    		tier5Arc.setLength(tier5Arc.getLength()+1); 
		    	}
		    	if(tier6Arc.getLength() < 361 && tier6Arc.getLength() < tier6Percent*3.6) {		    		
		    		tier6Arc.setLength(tier6Arc.getLength()+1); 
		    	}
		    }
		}));
		runner.setCycleCount(1000);
		runner.play();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {}
	
	@FXML
	public void goBack() {
		app.setSceneToStatistic();
	}
}