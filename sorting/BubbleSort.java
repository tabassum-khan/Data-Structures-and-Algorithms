package sorting;

public class BubbleSort {
	
	public static void bubbleSort(int a[], int n) {
		
		System.out.println();
		
		for (int i=0 ; i <n; i++) {
			for (int j=0; j<n-i-1; j++) {
				if (a[j] > a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	
		System.out.print("Bubble sort: ");
		for (int i=0; i<n; i++) {
			System.out.print( a[i] + ", ");
		}
	}
	
public static void bubbleSortDif(int a[], int n) {
		
		System.out.println();
		
		for (int i=n-2 ; i>= 0; i--) {
			for (int j=0; j<=i; j++) {
				if (a[j] > a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	
		System.out.print("Bubble sort Diff: ");
		for (int i=0; i<n; i++) {
			System.out.print( a[i] + ", ");
		}
	}
}
