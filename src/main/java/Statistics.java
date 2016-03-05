package main.java;

import java.util.ArrayList;

public class Statistics {
	
	private ArrayList<ArrayList<String>> usermaps;
	
	private ArrayList<String> tier1 = new ArrayList<String>();
	private ArrayList<String> tier2 = new ArrayList<String>();
	private ArrayList<String> tier3 = new ArrayList<String>();
	private ArrayList<String> tier4 = new ArrayList<String>();
	private ArrayList<String> tier5 = new ArrayList<String>();
	private ArrayList<String> tier6 = new ArrayList<String>();
	
	private double tempDouble;
	private int tier;
	MapList mapList = new MapList();
	
	public Statistics(ArrayList<ArrayList<String>> usermaps) {
		this.usermaps = usermaps;
		calcPercent();
	}
	
	public void calcPercent() {
		tier1.clear();
		tier2.clear();
		tier3.clear();
		tier4.clear();
		tier5.clear();
		tier6.clear();
		for(int i = 0; i < usermaps.size(); i++ ) {
			tier  = Integer.parseInt(usermaps.get(i).get(0));
			switch(tier) {
				case(1):
					tier1.add(usermaps.get(i).get(2));
					break;
				case(2):
					tier2.add(usermaps.get(i).get(2));
					break;
				case(3): 
					tier3.add(usermaps.get(i).get(2));
					break;
				case(4):
					tier4.add(usermaps.get(i).get(2));
					break;
				case(5): 
					tier5.add(usermaps.get(i).get(2));
					break;
				case(6): 
					tier6.add(usermaps.get(i).get(2));
					break;
			}
		}
	}
	public String tier1Percent() {
		if(tier1.size() > 0) {
			tempDouble = (double)tier1.size()/mapList.getTier1Maps().length;
			tempDouble = tempDouble * 100;
			tempDouble = Math.round(tempDouble * 100d) / 100d;
			return Double.toString(tempDouble);
		}
		return "0";
	}
	public String tier2Percent() {
		if(tier2.size() > 0) {
			tempDouble = (double)tier2.size()/mapList.getTier2Maps().length;
			tempDouble = tempDouble * 100;
			tempDouble = Math.round(tempDouble * 100d) / 100d;
			return Double.toString(tempDouble);
		}
		return "0";
	}
	public String tier3Percent() {
		if(tier3.size() > 0) {			
			tempDouble = (double)tier3.size()/mapList.getTier3Maps().length;
			tempDouble = tempDouble * 100;
			tempDouble = Math.round(tempDouble * 100d) / 100d;
			return Double.toString(tempDouble);
		}
		return "0";
	}
	public String tier4Percent() {
		if(tier4.size() > 0) {
			tempDouble = (double)tier4.size()/mapList.getTier4Maps().length;
			tempDouble = tempDouble * 100;
			tempDouble = Math.round(tempDouble * 100d) / 100d;
			return Double.toString(tempDouble);		
		}
		return "0";
	}
	public String tier5Percent() {
		if(tier5.size() > 0) {			
			tempDouble = (double)tier5.size()/mapList.getTier5Maps().length;
			tempDouble = tempDouble * 100;
			tempDouble = Math.round(tempDouble * 100d) / 100d;
			return Double.toString(tempDouble);
		}
		return "0";
	}
	public String tier6Percent() {
		if(tier6.size() > 0) {			
			tempDouble = (double)tier6.size()/mapList.getTier6Maps().length;
			tempDouble = tempDouble * 100;
			tempDouble = Math.round(tempDouble * 100d) / 100d;
			return Double.toString(tempDouble);
		}
		return "0";
	}
}