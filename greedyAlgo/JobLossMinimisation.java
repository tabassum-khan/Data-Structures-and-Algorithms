package greedyAlgo;

import java.util.*;

public class JobLossMinimisation {

	public static void main(String[] args) {
		int L[] = { 1, 2, 3, 5, 6 }; 
	    int T[] = { 2, 4, 1, 3, 2 }; 
	    
	    int[][] job = new int[L.length][L.length];
	    
	    for (int i=0; i<L.length; i++) {
	    	job[i][0] = L[i];
	    	job[i][1] = T[i];
	    }  
	    
	    sequenceJob(job);
	}

	private static void sequenceJob(int[][] job) {
		Arrays.sort(job, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if ((o2[0]*o1[1]) < (o1[0]*o2[1]))
					return -1;
				else
					return 1;
				//can be used this too
				//return ((o2[0]*o1[1]) - (o1[0]*o2[1]));
			}
		});
		
		for (int[] curr : job)
			System.out.println(curr[0]+ " " + curr[1]);
	}

}
