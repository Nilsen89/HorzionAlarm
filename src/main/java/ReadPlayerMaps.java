package main.java;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReadPlayerMaps {
	
	private BufferedReader br;
	private InputStreamReader isr;
	private FileInputStream fis;
	
	private final String filepath = this.getClass().getResource("/main/resources/cfg/usermaps.txt").toString();
	private ArrayList<ArrayList<String>> usermaps = new ArrayList<ArrayList<String>>();
	private String input, tempData;
	private int startData, stopData;
	private String[] tempRank;
	
	public ReadPlayerMaps() throws FileNotFoundException {
		fis = new FileInputStream(filepath);
		isr = new InputStreamReader(fis);
		br = new BufferedReader(isr);
	}
	
	public void readPlayerMaps() throws IOException {
		while((input = br.readLine()) != null) {
			if(input.equals("<tr>")) {
				usermaps.add(new ArrayList<String>());
				continue;
			} else if(input.equals("</tr>")) {
				tempRank = usermaps.get(usermaps.size()).get(4).split("/");
				usermaps.get(usermaps.size()).add(""+(Integer.parseInt(tempRank[0])/Integer.parseInt(tempRank[1]))+"");
				continue;
			} else {
				startData = input.indexOf("\">");
				stopData = input.indexOf("</");
				tempData = input.substring(startData, stopData);
				usermaps.get(usermaps.size()).add(tempData);
			}
		}
	}
	
	public ArrayList<ArrayList<String>> getPayerMaps() {
		return usermaps;
	}
	
}