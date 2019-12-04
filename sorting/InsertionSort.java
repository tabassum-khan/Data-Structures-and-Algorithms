package sorting;

public class InsertionSort {
	
	public static void insertionSort(int[] a, int n) {
		
		System.out.println();
	
		for (int i=1; i <= n-1; i++) {
			int x = a[i];
			int j= i;
			while ( j>0 && a[j-1] > x) {
				a[j] = a[j-1];
				j--;
			}
		a[j] = x;
		}
		System.out.println();
		System.out.print("Insertion Sort: " );
		for (int k =0; k<=n-1; k++) {
			System.out.print(a[k] + ", ");
		}
	}
	
	public static void invertInsertion(int a[], int n) {
		
		//System.out.println();	
		
		for (int i=1; i <= n-1; i++) {
			int x = a[i];
			int j= i;
			while ( j>0 && a[j-1] < x) {
				a[j] = a[j-1];
				j--;
			}
		a[j] = x;
		}
		System.out.println();
		System.out.print("Insertion Sort in decreasing order: " );
		for (int k =0; k<=n-1; k++) {
			System.out.print(a[k] + ", ");
		}
	}
}
