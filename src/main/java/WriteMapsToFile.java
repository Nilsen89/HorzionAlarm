package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class WriteMapsToFile {
	
	private PrintWriter pw = null;
	private File file;
	private final String filepath = getClass().getResource("/main/resources/cfg/usermaps.txt").getPath();
	
	//Constructor
	public WriteMapsToFile() throws UnsupportedEncodingException, FileNotFoundException {
		openFile();
	}
	
	//Opens the file, ready to write
	public void openFile() throws UnsupportedEncodingException, FileNotFoundException {
		file = new File(filepath);
		pw = new PrintWriter(file);
	}
	
	public void closeFile() {
		pw.close();
	}
	
	//Method to write input line to file
	public void writeLineToFile(String line) {
		pw.println(line);
	}
}