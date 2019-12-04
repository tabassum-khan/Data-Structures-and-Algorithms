package sorting;

import java.io.*;

public class QuickSortAnother {
	public static void main (String[] args) throws IOException	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
	    int arr[] = new int[n];
	    for(int i=0; i<n; i++) {
	    	//System.out.println(i);
	        arr[i] = Integer.parseInt(br.readLine());
	    }
	   
	   quickSort(arr, 0, arr.length-1);
	   for(int i=0; i<n; i++)
	    System.out.println(arr[i]);
	   
	}
	public static void quickSort(int[] arr, int start, int end) {
		if (start < end) {
			//System.out.println(start + " " + end);
			int pivot = partition(arr, start, end);
			System.out.println("pi:  " + pivot);
			quickSort(arr,start, pivot-1);
			quickSort(arr, pivot+1, end);
		}
	}
	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		System.out.println("pivot in prt: " + pivot);
		int pIndex = start;
		System.out.println(start + " " + end);
		for (int i=start; i<end; i++) {
			System.out.println("pIndex: " + pIndex);
			if (arr[i]<= pivot) {
				swap(arr, pIndex, i);
				pIndex++;
			}
		}
		System.out.println("p** " + pIndex);
		swap(arr, pIndex, end);
		return pIndex;
	}
	public static void swap(int[] a, int i, int j) {
		System.out.println("swapping " + a[i] + " and " + a[j]);
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
