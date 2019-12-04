package searching;

import java.util.Scanner;

public class BinarySearch {
	private static int[] arr = {10,20,30,40,50,60,70,80,90,100};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		if (binarySearch(x,0, arr.length))
			System.out.println("Binary Search : Found");
		else
			System.out.println("Binary Search: Not Found");
		
		int pos = binarySearchRec(x,0, arr.length);
		if (pos!=-1)
			System.out.println("Binary Search Recursive : Found at: " + pos);
		else
			System.out.println("Binary Search Recursive : Not Found");
		sc.close();
		
		sc.close();
	}

	private static boolean binarySearch(int x, int low, int high) {
		while(low<=high) {
			//System.out.println("low: " + low + " high: " + high) ;
			int mid = (low+high)/2;
			if (arr[mid]==x)
				return true;
			else if (x<arr[mid])
				high=mid-1;
			else
				low=mid+1;
		}
		return false;
	}
	private static int binarySearchRec(int x, int low, int high) {
		//System.out.println("low: " + low + " high: " + high ) ;
		if (low>high)
			return -1;
		else {
			int mid=(low+high)/2;
			if (arr[mid]==x)
				return mid;
			if (x<arr[mid])
				return binarySearchRec(x, low, mid-1);
			else
				return binarySearchRec(x, mid+1, high);
		}
	}
}
