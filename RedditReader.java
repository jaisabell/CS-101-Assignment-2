package reddit;

import java.util.*;
import java.io.*;
import java.lang.*;

public class RedditReader {
	
	Scanner fileReader;
	
	public List Posts = new ArrayList<String>();
	
	public void openFile() {
		try {
			fileReader = new Scanner(new File("Posts.txt"));
			System.out.println("File found!");
		}
		catch(Exception e) {
			System.out.println("File not found.");
		}
	}
	public void readFile() {
		while(fileReader.hasNext()) {
			Posts.add(fileReader.next());
		}
	}		
}

