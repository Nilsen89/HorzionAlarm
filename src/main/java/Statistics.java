package main.java;

import java.util.ArrayList;

public class Statistics {
	
	private ArrayList<ArrayList<String>> usermaps;
	private ArrayList<String> results;
	private String[] tempRank;
	
	public Statistics(ArrayList<ArrayList<String>> usermaps) {
		this.usermaps = usermaps;
		results = new ArrayList<String>();
	}
	
	public void mapRankPercent() {
		for(ArrayList<String> data : usermaps) {
			tempRank = data.get(4).split("/");
			percent.add(""+(double)(Integer.parseInt(tempRank[1])/Integer.parseInt(tempRank[0]))+"");		
		}
	}
	
	public ArrayList<String> getPercent() {
		return percent;
	}
	
}
