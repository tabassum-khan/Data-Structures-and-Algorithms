package recursion;

import java.io.*;

public class Subsequences {
	
	public static void main(String [] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String res = subsequences(str);
		System.out.println(res);
	}
	public static String subsequences(String word) {
		      if (word.isEmpty()) {
		          return ""; // base case
		      } else {
		          char firstLetter = word.charAt(0);
		          String restOfWord = word.substring(1);
		          
		          String subsequencesOfRest = subsequences(restOfWord);
		          
		         String result = "";
		         for (String subsequence : subsequencesOfRest.split(",", -1)) {
		             result += "," + subsequence;
		             result += "," + firstLetter + subsequence;
		         }
		        result = result.substring(1); // remove extra leading comma
		         return result;
		     }
}
}
