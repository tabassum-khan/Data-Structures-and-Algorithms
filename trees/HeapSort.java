package trees;

import java.util.Scanner;

public class HeapSort {
	
	private static int N;
	
	public void maxHeapify (int[] arr, int i) {
		System.out.println("In max heapify");
		int left = (2*i) + 1;
		int right = (2*i) + 2;
		int largest = 0;
		
		if (left < N && arr[left] > arr[i])
			largest = left;
		else
			largest = i;
		
		if (right < N && arr[right] > arr[largest])
			largest = right;
		
		if (largest != i) {
			swap(arr, i, largest);
			maxHeapify(arr, largest);
		}
	}//end maxHeapify();
	
	public void buildMaxHeap (int[] arr) {
		print(arr);
		for (int i=N/2; i>=0; i--)
			maxHeapify(arr, i);
	}
	
	public void swap(int[] arr, int i, int largest) {
		int temp = arr[i];
		arr[i] = arr[largest];
		arr[largest] = temp;
	}
	
	
	public void heapSort( int[] arr) {
		System.out.println("In heapsort");
		int heap_size = N-1;
		buildMaxHeap(arr);
		
		for(int i=N-1; i>=2; i--) {
			swap (arr, 0, i);
			heap_size--;
			maxHeapify(arr, heap_size);
		}
	}//end heapSort();
	
	
	public static void print(int[] arr) {
		for (int i=0; i<N; i++)
			System.out.print(arr[i] + " ");
	}
	
	public static void main(String[] args) {
		
		HeapSort hs = new HeapSort();
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		int[] arr = new int[N];
		
		for (int i=0; i<N; i++)
			arr[i] = sc.nextInt();
		
		hs.heapSort(arr);
		
		print(arr);
		
		sc.close();
	}

}
