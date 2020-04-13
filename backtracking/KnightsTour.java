package backtracking;

import java.util.*;

public class KnightsTour {

	private static int n;
	private static int[][] board;
	private static int[] x = {-2, -1, -1, -2, 2, 1, 1, 2};
	private static int[] y = {1, 2, -2, -1, -1, -2, 2, 1};
	private static int moves;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		board = new int[n][n];
		
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				board[i][j] = -1;
		
		board[0][0] = 0;
		
		if (solve(0, 0, 1))
			printSolution();
		else
			System.out.println("Solution does not exist");
		
		sc.close();
	}
	
	public static boolean solve(int x_source, int y_source, int moves) {
		if (moves == n*n)
			return true;
		
		
		for (int i=0; i<8; i++) {
			
			int next_x = x_source + x[i];
			int next_y = y_source + y[i];
			
			//System.out.println("next_x: " + next_x + " next_y: " + next_y + " moves: " + moves);
			if (isValid(next_x, next_y)) {
				board[next_x][next_y] = moves;
				
				if (solve(next_x, next_y, moves+1))
					return true;
				
				else {
					board[next_x][next_y] = -1;
					//--moves;
				}	
			}
		}//end for loop
		
		return false;
	}//end solve();
	
	
	public static boolean isValid(int x, int y) {
		if (x>=0 && x<n && y>=0 && y<n && board[x][y] == -1)
				return true;
		
		return false;
	}//end isValid();
	
	
	public static void printSolution(){
		
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++)
				System.out.print(board[i][j] + " ");
			
			System.out.println();
		}
	}//end printSolution();
}
