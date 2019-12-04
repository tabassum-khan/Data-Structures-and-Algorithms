package sorting;

public class Sort {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*SelectionSortExample selectionExample = new SelectionSortExample();
		selectionExample.selectionSortExample();*/
		
		int[] a = new int[] {10,50,30,40,20};
		int n = a.length;
		System.out.println("Lenghth of array: " + n);
		
		System.out.print("\nUnsorted array: " );
		for (int k=0; k<= n-1; k++) {
			System.out.print(a[k] + ", ");
		}
		
		Heapify heapify = new Heapify();
		int sortHeap[] = heapify.heapSort(a);
		
		PriorityQueues queue = new PriorityQueues();
		queue.heapMax(sortHeap);
		
		HeapSort heap = new HeapSort();
		int[] sort_heap = heap.heap(a, n);
		display(sort_heap);
		
		
		/*MergeSortSecond merge = new MergeSortSecond();
		merge.mergeSort(a);*/
		//int end = arr.length;
		HoareQuickSort hoareQuick = new HoareQuickSort();
		//hoareQuick.quickSort(a, 0, n-1);
		
		
		
		
		}
		
		/*BubbleSort bubble = new BubbleSort();
		bubble.bubbleSort(a, n);
		bubble.bubbleSortDif(a, n);
		
		InsertionSort insertion = new InsertionSort();
		insertion.insertionSort(a, n);
		insertion.invertInsertion(a, n);
		
		
		
		SelectionSortExample selectionExample = new SelectionSortExample();
		selectionExample.selectionSortExample();
		
		linearSearch(a, n);*/
		
	
	private static void linearSearch(int a[], int n) {
		System.out.println("\n");
		
		int value =2, i;
		boolean flag = false;
		for (i = 0; i<n;) {
			if (a[i] == value) {
				flag=true;
				break;
			}
			else 
				i++;
		}
		if (flag == true)
			System.out.println("Linear Search - value found at pos: " + (i+1));
		else 
			System.out.println("Linear Search - value not found");
	}
	
	public static void display(int[] a) {
		System.out.print("\nSorted Array: ");
		for (int i=0; i<a.length; i++) {
			System.out.print(a[i] + ", ");
		}
	}
}
