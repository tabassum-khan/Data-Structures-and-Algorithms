package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class TowerOfHanoi {

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		towerOfHanoi(n, 'A' , 'B', 'C');	
		
		Stack A= new Stack();
		Stack B = new Stack();
		Stack C = new Stack();
		for (int i=0; i<n; i++)
			A.push(i+1);
		System.out.println("A: " + A + " B: " + B + " C : " + C );
		towerOfHanoiStack(n, A, B, C);
	}
	
	private static void towerOfHanoiStack(int n, Stack from, Stack to, Stack aux) {
		
		if (n==1) {
			to.push(from.pop());
			System.out.println("A: " + from + " B: " + to + " C : " + aux);
			return;
		}
		towerOfHanoiStack(n-1, from, aux, to);
		to.push(from.pop());
		System.out.println("A: " + from + " B: " + to + " C : " + aux);
		towerOfHanoiStack(n-1, aux, to, from);		
	}

	private static void towerOfHanoi(int n, char from, char to, char aux) {
		if (n==1) {
			System.out.println("Disk 1 moved from " + from + " to " + to);
			return;
		}
		towerOfHanoi(n-1, from, aux, to);
		System.out.println("Disk " + n + " moved from " + from +" to "+ to );
		towerOfHanoi(n-1, aux, to, from);
	}

}
