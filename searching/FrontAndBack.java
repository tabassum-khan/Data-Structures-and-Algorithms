package searching;

import java.util.Scanner;

public class FrontAndBack {
	private static int[] arr = {100,20,50,30,40,70,8,0,10};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		int pos = fronAndBack(x);
		findPos(pos);
		int k = frontAndBackRec(x, 0, arr.length-1);
		findPos(k);
		
	}

	private static int fronAndBack(int x) {
		int front=0; int back=arr.length-1;
		
		while(front<=back) {
			if (arr[front]==x)
				return front;
			if (arr[back] == x)
				return back;
			front++;
			back--;
		}
		return -1;
	}
	
	private static int frontAndBackRec(int x, int front, int back) {
		if(front>back)
			return -1;
		if(arr[front]==x)
			return front;
		if(arr[back]==x)
			return back;
		
		return frontAndBackRec(x, front+1, back-1);
	}
	
	private static void findPos(int k) {
		if (k!=-1)
			System.out.println("Found at: " + k);
		else 
			System.out.println("Not Found");
	}

}
