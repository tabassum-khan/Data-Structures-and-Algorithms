package sorting;

import java.util.Scanner;

public class PriorityQueues {
	
	static int n=0;
	public static void heapMax(int[] arr) {
		n = arr.length;
		int max = arr[n-1];
		System.out.println("\n\nMax Element: "+max);
		
		int newArr[] = insertQueue (arr);
		System.out.println("\nAfter Insertion: ");
		display (newArr);
	}
	
	public static int[] insertQueue(int[] arr) {
		
		System.out.println("\nEnter an element: ");
		Scanner sc = new Scanner(System.in);
		int key = sc.nextInt();
		n++;
		//int n = arr.length;
		System.out.println("\nn: " + n);
		int i=n-1;
		arr[i] = key;
		
		while (key>0 && key > arr[(i-1)/2]) {
			swap(arr,i , (i-1)/2);
			i= (i-1)/2;
		}
		return arr;
	}
	
	public static void swap (int[] a, int i, int j) {
		//System.out.println("swapping " + a[i] + " and " + a[j]);
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void display(int[] a) {
		for (int i=0; i<a.length; i++) {
			System.out.print(a[i] + ", ");
		}
	}
}
