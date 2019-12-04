/*
 * You are climbing a stair case. It takes n steps to reach to the top. 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

package recursion;

import java.io.*;

public class Staircase {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int no_of_stairs = Integer.parseInt(br.readLine());
		
		int[] memo = new int[1000];
		memo(memo, no_of_stairs);
		
		int no_of_ways = staircase(no_of_stairs, memo);
		System.out.println(no_of_ways);
		
		int no_of_ways_loop = staircaseLoop(no_of_stairs);
		System.out.println(no_of_ways_loop);
	}
	
	private static void memo(int[] memo, int n) {
		for(int i=0; i<=n; i++)
			memo[i] = -1;
	}
	
	private static int staircaseLoop(int n) {
		int n_ways=0, num1=0, num2=1;
		if (n<=0)
			return n_ways;
		for(int i=1; i<=n;i++) {
			n_ways = num1+num2;
			num1=num2;
			num2=n_ways;
		}
		return n_ways;
	}

	private static int staircase(int n, int[] memo) {
		if (n<0)
			return 0;
		if (n==0||n==1)
			return 1;
		if (memo[n]!=-1)
			return memo[n];
		memo[n] = staircase(n-1, memo)+staircase(n-2, memo);
		return memo[n];
	}
	
}
