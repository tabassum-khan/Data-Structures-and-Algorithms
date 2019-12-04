package searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuessNumber {
	private static int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12, 13,14,15,16,17,18,19,20,30,40,50,60,70,80,90,100};
	
	public static void main(String[] args)throws IOException {
		
		System.out.println("GUESS A NUMBER FROM THE SET GIVEN BELOW: ");
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		
			
		if(binarySearch(0, arr.length))
			System.out.println("Found it!!!!!");
		else
			System.out.println("Not Found");
	}
	
	private static boolean binarySearch(int low, int high)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while(low<=high) {
				int mid = (low+high)/2;
				System.out.println("\nIs your number: " + arr[mid] + "?");
				String str = br.readLine();
				
				if (str.equalsIgnoreCase("N") || str.equalsIgnoreCase("No")) {
					System.out.println("Is it lower(L/l/low) or higher(H/h/high)?");
					String input = br.readLine();
					if (input.equalsIgnoreCase("L") || input.equalsIgnoreCase("LOW"))
						high=mid-1;
					else if (input.equalsIgnoreCase("H") || input.equalsIgnoreCase("HIGH"))
						low=mid+1;
					else
						System.out.println("\nPlease put the right input");
				}
				
				else if (str.equalsIgnoreCase("Y") || str.equalsIgnoreCase("Yes"))
					return true;
				else
					System.out.println("You didnt put the right input!!");
			}
		return false;
	}
}
