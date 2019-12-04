package sorting;

import java.util.Scanner;

public class SelectionSortExample {
	
	public static void selectionSortExample() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\nInput the number of words: ");
		int n = sc.nextInt();
		int[] alpha_freq = new int[n];
		System.out.println("Input the frequencies of " + n + " alphabets:");
		for(int i=0; i <n; i++) {
			alpha_freq[i] = sc.nextInt();
		}
		
		/*for (int i=0; i<n; i++) {
			System.out.print(alpha_freq[i] + ", ");
		}*/
		
		System.out.print("\n Input the number of keys: ");
		int key = sc.nextInt();
		
		System.out.println("\n Input the size of each key: ");
		int[] keySize = new int[key];
		for (int i=0; i<key; i++) {
			keySize[i] = sc.nextInt();
		}
		
		for (int i=0; i<key; i++) {
			System.out.print(keySize[i] + ", ");
		}
		
		SelectionSort selection = new SelectionSort();
		selection.selectionSortDesc(alpha_freq, n);
		
	}
}
