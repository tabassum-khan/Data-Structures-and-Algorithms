package trees;

import java.util.*;

public class BinaryHeap {
	
	private static int N;
	
	public void print(int[] arr) {
		for (int i=0; i<N; i++)
			System.out.print(arr[i] + " ");
	}
	
	public void maxHeapify (int[] arr, int i) {
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
		
		print(arr);
	}//end maxHeapify();
	
	
	public void minHeapify(int[] arr, int i) {
		//print(arr);
		int left = (2*i) + 1;
		int right = (2*i) + 2;
		int smallest = 0;
		
		if (left < N && arr[left] < arr[i])
			smallest = left;
		else
			smallest = i;
		
		if (right < N && arr[right] < arr[smallest])
			smallest = right;
		
		if (smallest != i) {
			swap(arr, i, smallest);
			minHeapify(arr, smallest);
		}
	}//end minHeapify();
	
	
	public void buildMaxHeap (int[] arr) {
		print(arr);
		for (int i=N/2; i>=0; i--)
			maxHeapify(arr, i);
	}
	
	
	public void buildMinHeap(int[] arr) {
		for (int i=N/2; i>=0; i--)
			minHeapify(arr, i);
	}
	
	
	public void swap(int[] arr, int i, int largest) {
		int temp = arr[i];
		arr[i] = arr[largest];
		arr[largest] = temp;
	}
	

	public static void main(String[] args) {
		
		BinaryHeap bh = new BinaryHeap();
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		int[] arr = new int[N];
		
		for (int i=0; i<N; i++)
			arr[i] = sc.nextInt();
		
		System.out.println("\nMAX HEAP: ");
		bh.buildMaxHeap(arr);
		bh.print(arr);	
		
		
		System.out.println("\n\nMIN HEAP: ");
		bh.buildMinHeap(arr);
		bh.print(arr);
		
	}

}
