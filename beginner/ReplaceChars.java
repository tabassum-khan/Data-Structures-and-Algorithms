package beginner;

import java.io.*;

public class ReplaceChars {
	private static int n =0;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder(br.readLine());
		/*
		 * StringBuilder newString = new StringBuilder(str); String string =
		 * str.toString(); //str = str.replace('a','c');
		 * 
		 * System.out.println("Öriginal String Builder: " + str); replace(str, 'a',
		 * 'c'); System.out.println("Replaces StringBuilder: " + str);
		 * 
		 * System.out.println("Original String: " + string); char[] myChars =
		 * string.toCharArray(); replaceChar(myChars, 'a', 'c');
		 * System.out.println("Replaced String: " + string);
		 */
		System.out.println("Original String Recursion: " + str);
		n=str.length();
		replaceCharRecursion(str, 'a', 'c');
		System.out.println("Replaced STring Recursion: " + str);
		
		String s = br.readLine();
		System.out.println("Original String: " + s);
		String newString = replaceChar(s, 'a', 'c');
		System.out.println("Replaced String: " + newString);
		
	}
	
	
	private static void replace(StringBuilder s, char ch1, char ch2) {
		if (ch1==ch2)
			return;
		for (int i=0; i<s.length(); i++) {
			if(s.charAt(i)==ch1)
				s.setCharAt(i, ch2);
		}
	}
	
	private static void replaceChar(char[] myChars, char c, char d) {
		if (c == d)
			return;
		for(int i=0; i<myChars.length;i++)
			if (myChars[i] == c)
				myChars[i] = d;
	}
	
	private static void replaceCharRecursion(StringBuilder s, char ch1, char ch2) {
		//System.out.println(s);
		n--;
		if (n<0 || ch1==ch2)
			return;
		if (s.charAt(n)==ch1) {	
			s.setCharAt(n, ch2);
		}
		replaceCharRecursion(s,ch1, ch2);

	}
	 private static String replaceChar(String str, char ch1, char ch2) {
			if (ch1 == ch2)
				return str;
			for(int i=0; i<str.length();i++) {
				System.out.println(str);
				if (str.charAt(i) == ch1)
					str = str.substring(0,i) + ch2 + str.substring(i+1, str.length());
			}
			return str;
		}
	
	/***
	 * 
	 * for string 
	 * 
	 * private static void replaceChar(String str, char ch1, char ch2) {
		if (ch1 == ch2)
			return;
		String s = "";
		for(int i=0; i<str.length();i++)
			if (str.charAt(i) == c)
				s =str.substring(0,i) + ch2 + str.substring(i+1, str.length());
		}
	 */
}
