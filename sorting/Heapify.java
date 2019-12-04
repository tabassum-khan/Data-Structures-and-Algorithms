package sorting;

public class Heapify{
	//static int n=0;
	static int largest = 0;
	
	public static int[] heapSort(int[] arr) {
		buildMaxHeap (arr);
		int n = arr.length;
		for (int i=n-1; i>=0; i--) {
			swap(arr,0, i);
			n--;
			maxHeapify(arr, 0,n);
		}	
		System.out.println("\nSort Max Heapify:");
		display(arr);
		
		return arr;
	}
	
	
	public static void buildMaxHeap(int[] arr) {
		int n = arr.length;
		for (int i=n/2; i>=0; i--) {
			maxHeapify (arr, i, n);
		}
		System.out.println("\nMax Heapify:");
		display(arr);
	}
	
	public static void maxHeapify (int[] arr, int i, int n) {
		//int n= arr.length;
		//System.out.println("i: " + i);
		int left = (2*i)+1, right = (2*i)+2;
		if (left<n && arr[left]>arr[i])
			largest = left;
		else 
			largest = i;
		if (right<n && arr[right]>arr[largest])
			largest=right;
		
		if (largest != i) {
			swap(arr, i, largest);
			maxHeapify(arr, largest, n);
		}
		//System.out.println("Reached here:");
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