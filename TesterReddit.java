package reddit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.lang.*;
import java.io.*;

public class TesterReddit{
	
	static ArrayList Posts = new ArrayList();

	public static void main(String[] args) {
		
		System.out.println("Input 3 keywords, and I will tell you how often they are mentioned in the reddit data.");
		Scanner input = new Scanner(System.in);
		String cs[] = new String[3];
		cs[0] = input.next();
		cs[1] = input.next();
		cs[2] = input.next();
		
		RedditReader Reader = new RedditReader();
		Reader.openFile();
		Reader.readFile();
		
		int result1 = Collections.frequency(Posts, cs[0]);
		int result2 = Collections.frequency(Posts, cs[1]);
		int result3 = Collections.frequency(Posts, cs[2]);
		
		System.out.println("I found " +result1+ " instances of '" +cs[0]+ "'.");
		System.out.println("I found " +result2+ " instances of '" +cs[1]+ "'.");
		System.out.println("I found " +result3+ " instances of '" +cs[2]+ "'.");
		
		
		input.close();
		
	}
}
