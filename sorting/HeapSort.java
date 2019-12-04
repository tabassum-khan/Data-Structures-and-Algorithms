package sorting;

public class HeapSort{
	
	public static int[] heap(int[] arr, int n) {
		
		int [] max_heap = maxHeap(arr, n);
		System.out.println("\nMax Heap: ");
		display (max_heap);
		
		int[] max_sort = delMaxHeap(max_heap);
		System.out.println("\nSort Max Heap:");
		display(max_sort);
		
		int[] min_heap = minHeap(arr,n);
		System.out.println("\nMin Heap: ");
		display(min_heap);
		
		int[] min_sort = delMinHeap(min_heap);
		System.out.println("\nSort Min Heap:");
		display(min_sort);
		
		return max_sort;
	}
	
	public static int[] maxHeap(int[] arr, int n) {
		int [] heap = new int[n];
		
		for(int i=0; i<n; i++) {
			int j=i;
			heap [j] = arr[i];
			
			while (j>0 && heap[j] > heap[(j-1)/2]) {
				swap (heap, j, (j-1)/2);
				j= (j-1)/2;
			}
		}
		return heap;
	}
	
	public static int[] minHeap(int[] arr, int n) {
		int [] heap = new int[n];
		
		for(int i=0; i<n; i++) {
			int j=i;
			heap [j] = arr[i];
			
			while (j>0 && heap[j] < heap[(j-1)/2]) {
				swap (heap, j, (j-1)/2);
				j= (j-1)/2;
			}
		}
		return heap;
	}
	
	public static int[] delMaxHeap(int[] heap) {
		int n = heap.length;
		while(n!=0) {
			int i=0, left, right; 
			
			//System.out.println("\n\nnode : " + heap[0]);
			swap (heap, i , n-1);
			n= n-1;
			left = (2*i)+1; right= (2*i)+2;
			
			while( (left <n && heap[i]<heap[left]) || (right<n && heap[i]<heap[right])) {
				//System.out.println("length: "+n); 
				//System.out.println("left child: "+heap[left]+ " " + left+" right child: "+heap[right]);
				if (left<n && right<n) {
					//System.out.println(" both children");
					if (heap[left] > heap[right]) {
						swap(heap, i , left);
						i=left;
					}
					else {
						swap(heap, i , right);
						i=right;
					}
				}
				else if (left<n) {
					//System.out.println("\nhas left child");
					swap(heap, i, left);
					i=left;
				}
				/*else {
					System.out.println("no child and exit");
					break;
				}*/
				left = (2*i)+1; right= (2*i)+2;
				//System.out.println("left : "+left+ " right: "+ right);
			}
		}
		return heap;
	}
	
	public static int[] delMinHeap(int[] heap) {
		int n = heap.length;
		while(n!=0) {
			int i=0, left, right; 
			
			//System.out.println("\n\nnode : " + heap[0]);
			swap (heap, i , n-1);
			n= n-1;
			left = (2*i)+1; right= (2*i)+2;
			
			while( (left <n && heap[i]>heap[left]) || (right<n && heap[i]>heap[right])) {
				//System.out.println("length: "+n); 
				//System.out.println("left child: "+heap[left]+ " " + left+" right child: "+heap[right]);
				if (left<n && right<n) {
					//System.out.println(" both children");
					if (heap[left] < heap[right]) {
						swap(heap, i , left);
						i=left;
					}
					else {
						swap(heap, i , right);
						i=right;
					}
				}
				else if (left<n) {
					//System.out.println("\nhas left child");
					swap(heap, i, left);
					i=left;
				}
				/*else {
					System.out.println("no child and exit");
					break;
				}*/
				left = (2*i)+1; right= (2*i)+2;
				//System.out.println("left : "+left+ " right: "+ right);
			}
		}
		return heap;
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