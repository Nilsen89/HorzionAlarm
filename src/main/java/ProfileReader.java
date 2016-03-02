package main.java;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProfileReader {
	public static ArrayList<String> getMaps(String name) {
		ArrayList<String> maps = new ArrayList<String>();
		try {
			URLConnection profileURL = new URL("https://www.horizonservers.net/stats/"+name).openConnection();
			profileURL.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			BufferedReader br = new BufferedReader(new InputStreamReader(profileURL.getInputStream()));
			
			String inputLine;
	        while ((inputLine = br.readLine()) != null) {
	        	if(inputLine.contains("class=\"map\">") && inputLine.contains("surf_")) {
	        		maps.add(inputLine.substring(inputLine.indexOf(">surf_")+1, inputLine.length()-9));
	        	}
	        }
	        br.close();
		} catch(IOException e) {
			System.out.println(e);
		}
		/*
		 * For loop for testing input from Horizon Site
		 */
		/*
		for(int i = 0; i < maps.size(); i++) {
			System.out.println(maps.get(i));
		}
		*/
		return maps;
	}
}