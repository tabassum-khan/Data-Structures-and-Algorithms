package searching;

import java.io.*;

public class LinearSearch {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		while ((input=br.readLine())!=null) {
			int num = Integer.parseInt(input);
			int[] a= {100,20,50,30,40,70,8,0,10};
			
			if (linearSearch(num, a)) 
				System.out.println("Found");
			else
				System.out.println("Not Found");
		}
	}

	private static boolean linearSearch(int num, int[] a) {
		for(int i=0; i<a.length; i++)
			if(a[i]==num)
				return true;
		return false;
	}
}
