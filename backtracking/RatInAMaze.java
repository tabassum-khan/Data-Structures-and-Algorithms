package backtracking;

import java.util.Scanner;

public class RatInAMaze {
	
	private static int N = 6;
	private static int[] x = {0, 1, -1, 0};
	private static int[] y = {1, 0, 0, -1};
	
	public static void main(String[] args) {

		int[][] maze ={ 
						{ 1, 0, 1, 1, 1, 1 }, 
                		{ 1, 1, 1, 0, 0, 1 }, 
                		{ 1, 0, 0, 0, 1, 1 }, 
                		{ 1, 0, 1, 1, 1, 0 },
                		{ 1, 0, 1, 0, 0, 1 },
                		{ 1, 0, 1, 1, 1, 1 } 
                	}; 
		maze[0][0] = 5;
		if (solve(maze, 0 , 0))
			printSolution(maze);
		else
			System.out.println("Solution doesnt exist");
	}
	
	public static boolean solve(int[][] maze, int x_source, int y_source) {
		if (x_source == N-1 && y_source == N-1)
			return true;
		
		for (int i=0; i<4; i++) {
			int next_x = x_source + x[i];
			int next_y = y_source + y[i];
			//System.out.println(next_x + " " + next_y);
			
			//printSolution(maze);
			if (isValid (maze, next_x, next_y)) {
				maze[next_x][next_y] = 5;
				if (solve(maze, next_x, next_y))
					return true;
				maze[next_x][next_y] = 0;
			}
		}
		
		return false;
	}//end solve();
	
	
	public static boolean isValid (int[][] maze, int x, int y) {
		if (x>=0 && x<N && y>=0 && y<N && maze[x][y] == 1)
			return true;
		return false;
	}//end isValid()
	
	
	public static void printSolution(int[][] maze){
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++)
				System.out.print(maze[i][j] + " ");
			
			System.out.println();
		}
		System.out.println("\n");
	}//end printSolution();

}
