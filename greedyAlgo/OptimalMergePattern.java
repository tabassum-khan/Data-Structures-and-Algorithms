package greedyAlgo;

import java.util.PriorityQueue;

public class OptimalMergePattern {

	public static void main(String[] args) {
		int files[] = new int[] { 2, 3, 4, 5, 6, 7 }; 
		System.out.println(minComputation(files));
	}

	private static int minComputation(int[] files) {
		int n = files.length;
		int count = 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer> ();
		
		for (int i=0; i<n; i++)
			pq.add(files[i]);
		
		while(pq.size() > 1) {
			int temp = pq.poll() + pq.poll();
			count += temp;
			pq.add(temp);
		}
		
		return count;
	}

}
