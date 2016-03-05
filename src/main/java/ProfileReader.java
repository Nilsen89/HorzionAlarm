package main.java;

import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class ProfileReader {
	
	public static boolean getMaps(String name) throws UnsupportedEncodingException, FileNotFoundException {
		
		boolean runner = false;
		WriteMapsToFile wmtf = new WriteMapsToFile();
		
		try {
			
			URLConnection profileURL = new URL("https://www.horizonservers.net/stats/"+name).openConnection();
			profileURL.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			BufferedReader br = new BufferedReader(new InputStreamReader(profileURL.getInputStream()));
			
			String inputLine;
	        while ((inputLine = br.readLine()) != null) {
	        	if(!runner && inputLine.equals("<tbody>")) {
	        		runner = true;
	        		continue;
	        	} else if(runner && inputLine.equals("</tbody>")) {
	        		break;
	        	} if(runner) {
	        		wmtf.writeLineToFile(inputLine);
	        	}
	        	
	        	/*if(inputLine.contains("class=\"map\">") && inputLine.contains("surf_")) {
	        		maps.add(inputLine.substring(inputLine.indexOf(">surf_")+1, inputLine.length()-9));
	        	}*/
	        }
	        
	        wmtf.closeFile();
	        br.close();
	        
	        if(!runner) {
	        	return false;
	        }
	        return true;
	        
		} catch(IOException e) {
			System.out.println(e);
			return false;
		}
	}
}