package sorting;

import java.util.Random;

public class HoareQuickSort {
	
	public static void quickSort(int[] arr, int start, int end) {
		System.out.println("\nIn quick Sort, start: "+ start + " end: " + end);
		if (start < end) {
			int pivot = randomizedPartition(arr, start, end);
			
			quickSort(arr,start, pivot-1);
			quickSort(arr, pivot+1, end);
		}
	}
	
	public static int randomizedPartition (int[] arr, int start, int end) {
		Random rn = new Random();
		int pivot = rn.nextInt((end-start)+1)+start;
		//System.out.println("\npivot is: " + arr[pivot]);
		swap (arr, pivot, start);
		//System.out.println("in random, start: "+ start + " end: " +end);
		return hoarePartition(arr, start, end);

	}
	
	public static int hoarePartition(int[] arr, int start, int end) {
		//System.out.println("in partition, start: "+ start + " end: "+end);
		int pivot = arr[start] ;
		System.out.println("\npivot is: " + pivot);
		int i = start-1;
		int j= end+1;
		while(true) {
			do{
				j--;
			}while (arr[j] > pivot && j>0);
			System.out.println("j: "+j);
			do {
				i++;
			}while (arr[i] <= pivot && i <end);
			System.out.println("i: "+i);
			if (i>=j) {
				System.out.println("Returning J : "+j);
				swap (arr, start ,j);
				return j;	
			}
			swap(arr, i, j);
		}
	}
	
	public static void swap(int[] a, int i, int j) {
		System.out.println("swapping " + a[i] + " and " + a[j]);
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
