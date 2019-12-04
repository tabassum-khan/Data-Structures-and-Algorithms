/***Staircase problem with number of steps X=[1,3,5]***/

package recursion;

import java.util.Scanner;

public class StaircaseWithSets {
	
	private static final int[] steps = {1,3,5};
	private static int[] memo = new int[1000];
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		//int test =sc.nextInt();
		while(sc.hasNext()) {
			int no_of_stairs = sc.nextInt();
			
			int no_of_ways = staircase(no_of_stairs);
			System.out.println("t_ways : " + no_of_ways);
			
			int n_ways = calcStaircase(no_of_stairs);
			System.out.println("n_ways: " + n_ways);
			
			memo(no_of_stairs);
			int ways= calcStairs(no_of_stairs);
			System.out.println("ways: " + n_ways);
		}
	}
	private static void memo(int n) {
		for(int i=0; i<=n; i++)
			memo[i] = -1;
		memo[0]=1;
		memo[1]=1;
	}
	
	private static int calcStairs(int n) {
		if(n<0)
			return 0;
		if (memo[n]!=-1)
			return memo[n];
		
		int t_ways =0;
		
		for(int i=0; i<steps.length;i++) {
			t_ways += calcStairs(n-steps[i]);
			memo[n] = t_ways;
		}
		return memo[n];
	}

	private static int calcStaircase(int n) {
		if (n<0)
			return 0;
		if (n==0 || n==1)
			return 1;
		return calcStaircase(n-1) + calcStaircase(n-3) + + calcStaircase(n-5);
	}
	
	
	private static int staircase(int n) {
		if (n<0)
			return 0;
		if (n==0 || n==1)
			return 1;
		int t_ways =0;
		
		for(int i=0; i<steps.length;i++)
			t_ways += staircase(n-steps[i]);
		
		return t_ways;
	}

}
