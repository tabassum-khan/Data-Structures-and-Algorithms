package backtracking;

import java.util.*;

public class NQueens {
	private static int n = 4;
	private static int[][] board;
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		 board = new int[n][n];
		 
		for (int i=0; i<n; i++)
		    for (int j=0; j<n; j++)
		        board[i][j] = 0;
		        
		if (solve (0))
		    printSolution();
		else
		    System.out.println("Solution does not exist");
		
		s.close();
	}
	
	public static boolean solve (int row){
	    //System.out.println("Row: " + row);
	    if (row >= n)
	        return true;
	        
	    for (int col=0; col<n; col++){
	        
	        if (isSafe(row, col)){
	            board[row][col] = 1;
	            
	            //recur to see if we can reach the solution with the decision made
	            if (solve(row+1))
	                return true;
	            
	            //backtrack
	            board[row][col] = 0;
	        }
	        
	    }//end for loop
	    
	    return false;
	    
	}// end solve();
	
	public static boolean isSafe(int row, int col){
		
		//System.out.println("Row: " + row + " Col: " + col);
	    
	    //check for if any other queen exists in that column
	    for (int j = 0; j < row; j++)
	        if (board[j][col] == 1)
	            return false;
	            
	    //check for Left Upper diagonals
	    int i, j;
	    for (i=row-1, j=col-1; i>=0 && j>=0; i--,j--){
			if (board[i][j] == 1)
				return false;
		}
		
		//check for Right Upper diagonals
	    for (i=row-1, j=col+1; i>=0 && j<n; i--,j++){
			if (board[i][j] == 1)
				return false;
		}
		
		//check for Left Lower diagonals
	    for (i=row+1, j=col-1; i<n && j>=0; i++,j--){
			if (board[i][j] == 1)
				return false;
		}
		
		//check for Right Lower diagonals
	    for (i=row+1, j=col+1; i<n && j<n; i++,j++){
			if (board[i][j] == 1)
				return false;
		}
	    
	    return true;
	    
	}//end isSafe();
	
	public static void printSolution(){
		
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++)
				System.out.print(board[i][j] + " ");
			
			System.out.println();
		}
	}//end printSolution();
}
