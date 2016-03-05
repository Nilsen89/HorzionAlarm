package main.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class UsermapsParser {
	
	private BufferedReader br;
	private String tier, style, map, time, rank, comp; 
	private ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
	private ArrayList<String> maps = new ArrayList<String>();
	private final String filePath = this.getClass().getResource("/main/resources/cfg/usermaps.txt").getFile();
	
	public void parseData() throws FileNotFoundException, IOException {
		
			br = new BufferedReader(new FileReader(filePath));
			
		    String line;
		    while((line = br.readLine()) != null) {
		    	line = br.readLine();
		    	tier = line.substring(17,18);
		    	if(!line.substring(18,19).equals("<")) {
		    		for(int i = 0; i < 6; i++) {			
		    			br.readLine();
		    		}
		    		continue;
		    	}
		    	line = br.readLine();
		    	style = line.substring(39, line.indexOf("</td>"));
		    	if(!style.equals("Normal")) {
		    		for(int i = 0; i < 5; i++) {	    			
		    			br.readLine();
		    		}
		    		continue;
		    	}
		    	line = br.readLine();
		    	map = line.substring(line.indexOf(">surf")+1, line.indexOf("</a></td>"));
		    	time = br.readLine().substring(17, 25);
		    	line = br.readLine();
		    	rank = line.substring(17, line.indexOf("</td>"));
		    	comp = br.readLine().substring(17, 18);

		    	data.add(new ArrayList<String>());

		    	br.readLine();
		    	maps.add(map);
		    	data.get(data.size()-1).add(tier);
		    	data.get(data.size()-1).add(style);
		    	data.get(data.size()-1).add(map);
		    	data.get(data.size()-1).add(time);
		    	data.get(data.size()-1).add(rank);
		    	data.get(data.size()-1).add(comp);
		    }
	}
	public ArrayList<String> getMaps() {
		return maps;
	}
	public ArrayList<ArrayList<String>> getData() {
		return data;
	}
}