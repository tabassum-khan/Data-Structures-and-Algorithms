package backtracking;

import java.util.*;

public class SubsetSum {
	
	private static int N;
	private static int M;
	private static int[] arr ;
	private static int[] sol ;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int total = 0;
		
		arr = new int[N];
		sol = new int[N];
		
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			total += arr[i];
		}
		
		if (M > total)
			System.out.println("Solution doesnt exist");
		else{
			if (subsetSum(0, 0, total))
			printSolution(sol);
		else
			System.out.println("Solution doesnt exist");
		}
		sc.close();
	}
	
	
	public static boolean subsetSum (int i, int sum, int rem) {
		//System.out.println(i + " ===== sum : " + sum + " rem: " + rem );
		//System.out.println("SS::::::::::;: "+ Arrays.toString(sol));
		//System.out.println("::::::SS::::::");
		if (sum == M)
			return true;
		
		for (int j=i; j<N; j++) {
			
			if (isValid(j, sum + arr[j], rem - arr[j])) {
				//System.out.println("j: " + j);
				sol[j] = arr[j];
				//System.out.println(Arrays.toString(sol) + " sum : "  + sum);

				if (subsetSum(j+1, sum+arr[j], rem-arr[j]))
					return true;
				sol[j] = 0;
				
				//System.out.println("After return::: " + Arrays.toString(sol));
			}
		}
		
		return false;
	}
	
	
	public static boolean isValid(int i, int sum, int rem) {
		//System.out.println("ISVALID : " + i + " " + sum + " " + rem);
		if (sum <= M && rem+sum >= M && i<N)
			return true;
		return false;
	}
	
	public static void printSolution(int[] arr) {
		for (int i=0; i<N; i++)
			System.out.print(arr[i] + " ");
	}
}
