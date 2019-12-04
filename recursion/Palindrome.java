package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		if (isPalindrome(str))
			System.out.println("Yes");
		else
			System.out.println("No");
	}	
	
	private static boolean isPalindrome(String str) {
	//	System.out.println(str);
		if (str.length()==1)
			return true;
		if(str.charAt(0) != str.charAt(str.length()-1)) 
			return false;
		if (str.length()==2 )
			return true;
	
		return isPalindrome(str.substring(1, str.length()-1));
	}
}
