package greedyAlgo;

class Heapify {
	public static int heap_size = 0;

	public static void minHeapify(HuffmanNode[] arr, int i) {
		int left = 2*i;
		int right = 2*i+ 1;
		int smallest;
		if (left <= heap_size && arr[left].freq < arr[i].freq)
			smallest = left;
		else
			smallest = i;
		
		if (right <= heap_size && arr[right].freq < arr[smallest].freq)
			smallest = right;
		
		if (smallest != i) {
			HuffmanNode temp = arr[smallest];
			arr[smallest] = arr[i];
			arr[i] = temp;
			
			minHeapify(arr, smallest);
		}
		
	}
}


public class HuffmanPriorityQueue{
	static HuffmanNode[] arr;
	private int capacity;
	private static int size = 0;
	
	HuffmanPriorityQueue(int capacity) {
		this.capacity = capacity;
		arr = new HuffmanNode[capacity];
	}
	
	
	@Override
	public String toString() {
		String s = "{";
		for (int i=1; i<size(); i++)
			s += arr[i].ch + ": " + arr[i].freq + ", ";
		s += arr[size].ch + ": " + arr[size].freq + "}";
		return s;
	}
	
	
	public int size() {
		return size==0 ? -1 : this.size;
	}
	
	public static HuffmanNode[] add(HuffmanNode node) {
		int index = ++size;
		Heapify.heap_size++;
		arr[index] = node;
		
		
		while(index > 1 && arr[index/2].freq > arr[index].freq) {
			HuffmanNode temp = arr[index/2];
			arr[index/2] = arr[index];
			arr[index] = temp;
			
			index = index/2;
		}
		
		return arr;
	}
	
	public static HuffmanNode extractMin() {
		if (size == 0)
			return null;
		
		HuffmanNode min = arr[1];
		arr[1] = arr[size];
		arr[size] = null;
		
		Heapify.heap_size--;
		size--;
		
		Heapify.minHeapify(arr, 1);
		
		return min;
	}
	

	public static void main(String[] args) {
		HuffmanPriorityQueue pq = new HuffmanPriorityQueue(8);
		
		char[] ch = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
		int[] freq = {5, 6, 4, 8, 4, 3, 1};
		
		System.out.println(ch.length == freq.length);
		
		for (int i=0; i<ch.length; i++) {
			HuffmanNode new_node = new HuffmanNode(ch[i], freq[i]);
			pq.add(new_node);
		}
		
		HuffmanNode[] pq_arr = pq.arr;
		
		for (HuffmanNode curr : pq_arr) 
			if (curr != null)
				System.out.println(curr.ch + " : " + curr.freq);
		
		System.out.println(pq.size());
		
		System.out.println(pq.extractMin().ch);
		System.out.println(pq.extractMin().ch);
		System.out.println(pq.extractMin().ch);
		
		for (HuffmanNode curr : pq_arr) 
			if (curr != null)
				System.out.println(curr.ch + " : " + curr.freq);
		
		System.out.println(pq.size());
	
	}

	
}
