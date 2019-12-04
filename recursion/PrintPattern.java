package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintPattern {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = "";
		while ((n = (br.readLine())) != null) {
			int num = Integer.parseInt(n);
			int i = num;
			boolean flag = false;
			printPattern(num, i, flag);
			System.out.println("\n");
			printAnotherPattern(num);
			System.out.println("\nPrint Triangle Star with loop:");
			int j=0, k=0;
			printStar(num, j);
			System.out.println("\nPrint star wihtout Loop:");
			PrintStarNoLoop(num, j);
			System.out.println("\nPRint Triangle Star without Loop: ");
			int l=num;
			printStarTrianlge(num, num, 0,0);	
			System.out.println("\nPRint Triangle using only one variable: ");
			printtri(num);
		}
	}
	public static void printtri(int count) {
	    if (count == 0) return;

	    System.out.print("* ");
	    printtri(count - 1);
	}
	private static void printStarTrianlge(int o_num, int num, int j, int k) {
		//System.out.println(j + " " + k);
		if (num<1)
			return;
		if (k+num<=o_num) {
			System.out.print("1 ");
			printStarTrianlge(o_num, num, j, k+1);
			System.out.print("1 ");
		}
		else {
			if (j<num) {		
				System.out.print("* ");
				printStarTrianlge(o_num, num, j+1, k);
				System.out.print("* ");
			}
			else {	
			System.out.println();
			printStarTrianlge(o_num, num-1,0 , 0);
			System.out.println();
			}
		}
	}

	private static void PrintStarNoLoop(int num, int j) {
		//System.out.println("heyy");
		if (num<0)
			return;
		if (j<num) {
			System.out.print("* ");
			PrintStarNoLoop(num, j+1);
			System.out.print("* ");
		}
		else {
			System.out.println();
			PrintStarNoLoop(num-1,0);
			System.out.println();
		}
	}

	private static void printStar(int num, int j) {
		System.out.println();
		if (j>=num)
			return;
		else {
			
			for (int i=0; i<=num-j; i++)
				System.out.print(" ");
			for (int k=0; k<j;k++)
				System.out.print("* ");
			printStar(num, j+1);
			for (int i=0; i<=num-j; i++)
				System.out.print(" ");
			for (int k=0; k<j;k++)
				System.out.print("* ");
			
		}
		System.out.println();
	}

	private static void printAnotherPattern(int num) {
		//System.out.println("Heyy");
		if (num<=0) {
			System.out.print(num + " ");
			return;
		}
		System.out.print(num + " ");
		printAnotherPattern(num-5);
		System.out.print(num + " " );
	}

	private static void printPattern(int num, int i, boolean flag) {
		System.out.print(i + " ");
		if (i>=num && flag==true)
			return;
		if (i>0 && flag== false)
			printPattern(num, i-5, false);
		else
			printPattern(num, i+5, true);
	}

}
