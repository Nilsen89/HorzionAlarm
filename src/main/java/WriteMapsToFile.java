package main.java;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class WriteMapsToFile {
	
	private PrintWriter pw;
	private final String filepath = this.getClass().getResource("/main/resources/cfg/usermaps.txt").toString();
	private final String encoding = "UTF-8";
	
	//Constructor
	public WriteMapsToFile() {}
	
	//Opens the file, ready to write
	public void openFile() throws UnsupportedEncodingException, FileNotFoundException {
		pw = new PrintWriter(filepath, encoding);
	}
	
	//Method to write input line to file
	public void writeLineToFile(String line) {
		pw.println(line);
	}
	
}
