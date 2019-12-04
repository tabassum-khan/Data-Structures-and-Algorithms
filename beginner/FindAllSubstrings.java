package beginner;

import java.io.*;

public class FindAllSubstrings {
	private final static int MAX = 1000;
	private static int size = 0;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		//int a[] = new int[10];
		//int size = 0;
		String[] array = findSubstring(str);
		
		for (int i=0; i<size;i++)
			System.out.print(array[i]+ " ");
		
		System.out.println("\n\n");
		
		String [] arr = findSubstring2(str);
		for (int i=0; i<size;i++)
			System.out.print(arr[i]+ " ");
		
		System.out.println("\n\n");
		
		SubString(str);
	}
	private static String[] findSubstring2(String str) {
		if(str==null)
			return null;
		String[] a = new String[MAX];
		int size=0;
		for (int i=0; i<str.length(); i++) {
			for(int j=i; j<str.length(); j++) {
				a[size] = str.substring(i, j+1);
				size++;
			}
		}
		return a;
	}
	
	
	private static String[] findSubstring(String str) {
		String a[] = new String[MAX];
		//System.out.println(size + " " + a.length+ " " + str.length());
		if (str==null)
			return a;
		for(int i=0; i<str.length();i++) {
			String s="";
			for (int j=i; j<str.length(); j++) {
				//11System.out.println(j + " " +str.charAt(j));
				s = s+str.charAt(j);
				//System.out.println(s);
				a[size] = s;
				size++;
			}
		}
		return a;
	}
	
	
	public static void SubString(String str) 
    { 
		int n = str.length();
       for (int i = 0; i < n; i++)  
           for (int j = i+1; j <= n; j++) 
             
                // Please refer below article for details 
                // of substr in Java 
                // https://www.geeksforgeeks.org/java-lang-string-substring-java/ 
                System.out.print(str.substring(i, j) + "\t"); 
    } 
  
}
