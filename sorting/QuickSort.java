/**
 * while (i <=j) {
			if (arr[i] >= pivot) {
				swap (arr, i, j);
				if (arr[j] < pivot) {
					i++;
					swap (arr, i, j);
				}
				else
					j--;
			}
			else 
				i++;
		}
 */

package sorting;

public class QuickSort {
	
	public static void main(String[] args) {
		int[] arr = {5, 6, 11, 14, 19, 20, 23, 32, 54, 65, 78, 87, 88}; 
		int a[] = quickSort(arr, 0, arr.length-1);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + ", ");
		}
	}
	public static int[] quickSort(int[] arr, int start, int end) {
		if (start < end) {
			int pivot = partition(arr, start, end);
			
			quickSort(arr,start, pivot-1);
			quickSort(arr, pivot+1, end);
		}
		return arr;
	}
	
	public static int partition(int[] arr, int start, int end) {
		//System.out.println("\nEntered quicksort");
		int pivot = arr[start];
		//System.out.println("pivot is: " + pivot);
		int i= start+1, j=end;
		/*
		 * while(i<j) { if (arr[i]<pivot) i++; if (arr[j]>pivot) j--; if (arr[i]>pivot
		 * && arr[j]<pivot) { swap(arr, i, j); i++; j--; } }
		 */
		/*
		 * for(int k=0; k<arr.length; k++) System.out.print(arr[k] + " ");
		 */
		while (i <=j) {
			if (arr[i] >pivot) {
				swap (arr, i, j);
				if (arr[j] < pivot) {
					i++;
					swap (arr, i, j);
				}
				else
					j--;
			}
			else 
				i++;
		}
		/*
		 * if (arr[i-1]<=pivot) { swap(arr, i-1, start); return (i-1); } else {
		 */
			swap(arr, i-1, start);
			return i-1;
		//}
		
		
	}
	
	public static void swap(int[] a, int i, int j) {
		//System.out.println("swapping " + a[i] + " and " + a[j]);
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
