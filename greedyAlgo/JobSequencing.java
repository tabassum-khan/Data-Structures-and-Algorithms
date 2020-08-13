package greedyAlgo;

import java.util.*;

class Job{ 
	char jobId;
	int deadline, profit;
	
	Job(char j, int d, int p){
		jobId = j;
		deadline = d;
		profit = p;
	}
	
	 public String toString() {
		 return jobId + ": " + deadline + ", " + profit;
	 }
}


//USER DEFINED COMPARATOR
class JobComp implements Comparator <Job>{
	@Override
	public int compare(Job o1, Job o2) {
		if (o1.profit<o2.profit)
			return 1;
		else 
			return -1;
	}
}

public class JobSequencing {
		
	public static char[] getJobSequence(int[] deadline, int[]profit) {
		
		ArrayList<Job> jobs = new ArrayList<Job>();
		char jobId = 'a';
		//Adding elements to collection
		for (int i=0;i<deadline.length; i++) {
			jobs.add(new Job(jobId++, deadline[i], profit[i]));
		}
		
		//Sorting collections in reverse order of profits
		Collections.sort(jobs, new JobComp());
		
		//Displaying SORTED elements of collections
		System.out.println("Sorted Job Collection based on profit:");
		for (Job element:jobs)
			System.out.println(element);
		
		//Initiating slots[] to false
		boolean slots[] = new boolean[deadline.length];
		for (int i=0; i<deadline.length;i++) {
			slots[i] = false;
		}
		
		//INITIALISING RESULT TO '0'
		char[] result = new char[deadline.length];
		for (int i=0; i<deadline.length; i++)
				result[i] = '0';
		
		//Sequencing job
		for (int i=0; i<deadline.length; i++) { //LOOPS THROUGH ALL THE ELEMENTS IN THE COLLECTION
			for(int j=jobs.get(i).deadline-1; j>=0;j--) { //INITIALISES j TO DEADLINE-1 OF THE CURRENT ELEMENT
				
				if (!slots[j]) { //IF SLOT IS FILLED, THEN j LOOPS over RESULT
					
					//System.out.println(jobs.get(i).jobId + " " + jobs.get(i).deadline);
					result[j] = jobs.get(i).jobId; //ADD this job to result
					slots[j] = true; //make the slots true
					break;
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int deadline[] = {2,1,2,1,3};
		int profit[] = {100,19,27,25,15};
		
		char arr[] = getJobSequence(deadline, profit);
		
		System.out.println("\nJob sequence:");
		for (int i=0; i<arr.length; i++) {
			if (arr[i]!= '0')
				System.out.print(arr[i] + " ");
		}
	}

}
