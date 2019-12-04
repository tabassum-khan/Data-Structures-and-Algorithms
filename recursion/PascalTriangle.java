package recursion;

import java.util.Scanner;

public class PascalTriangle {
	private static int[][] memo = new int[1000][1000];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			int a[][] = new int[n][n];
			pascal(n, a);
			for(int i=0; i<n; i++) {
				for(int k=0; k<=n-i;k++)
					System.out.print(" ");
				for(int j=0; j<=i; j++) {
					System.out.print(a[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println("Pascal Rec: ");
			
			memo(n);
					
			for (int i=0;i<n;i++) {
				for(int j=0; j<=i;j++) 					
					System.out.print(calcPascal(i, j) + " ");			
			System.out.println();
			}

		}
		sc.close();
	}
	private static void memo(int n) {
		for (int i=0; i<n; i++) {
			for (int j=0; j<=i; j++) {
				if (j==0 || j==i)
					memo[i][j]=1;
				else
					memo[i][j]=-1;
			}
		}
	}
	private static void pascal(int n, int[][] a) {
		//System.out.println("Entered");
		if (n==0)
			return;
		for(int i=0; i<n; i++) {
			for(int j=0; j<=i; j++) {
				if (j==0 || j==i)
					a[i][j] = 1;
				else
					a[i][j] = a[i-1][j-1] + a[i-1][j];
				//System.out.print(a[i][j] + " ");
			}
			//System.out.println();
		}
	}
	public static int calcPascal(int row, int column) {
		if (row<0 || column<0)
			return 0;
		if (memo[row][column]!=-1)
			return memo[row][column];
		else 
			memo[row][column]= calcPascal(row - 1, column - 1) + calcPascal(row - 1, column);
		return memo[row][column];
	}

}		
