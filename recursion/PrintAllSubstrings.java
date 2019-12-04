package recursion;

import java.io.*;

public class PrintAllSubstrings {
	private static final int MAX = 1000;
	private static int size = 0, count=0;
	private static String[] array= new String[MAX];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		findAllSubstrings(str);
		
		for (int i=0; i<size; i++) 
		  System.out.print(array[i] + " ");
		 
	}
	
	private static  void findAllSubstrings(String str) {
		if(str.length()<1)
			return;
		array[size]=str;
		size++;
		//count keeps a check on the tree that we should only move forward when we are parsing the string for the first time 
		//and thus doesnt allow to print substrings repeatedly.
		if (count<=str.length()) {
			count++;
			findAllSubstrings(str.substring(1, str.length()));
		}
		count++; 
		findAllSubstrings(str.substring(0, str.length()-1));		
	}
}
