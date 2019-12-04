package sorting;

public class SelectionSort {

	public static void selectionSort(int a[] , int n) {
		System.out.println();
		int key, pos = 0;
		for (int i=0; i<n-1; i++) {
			key = a[i];
			for (int j=i+1; j<n; j++) {
				if (key > a [j]) {
					key = a[j];
					pos = j;
				}
			}
		a[pos] = a[i];
		a[i]=key;
		}
		
		System.out.print("Selection Sort: ");
		for (int i=0; i<n; i++) {
			System.out.print(a[i] + ", ");
		}
	}
	
	public static void selectionSortDesc(int a[] , int n) {
		System.out.println();
		int key, pos = 0;
		for (int i=0; i<n-1; i++) {
			key = a[i];
			for (int j=i+1; j<n; j++) {
				if (a[j] > key) {
					key = a[j];
					pos = j;
				}
			}
		a[pos] = a[i];
		a[i]=key;
		}
		
		System.out.print("Selection Sort Descending: ");
		for (int i=0; i<n; i++) {
			System.out.print(a[i] + ", ");
		}
	}
}
