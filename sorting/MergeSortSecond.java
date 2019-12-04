package sorting;

public class MergeSortSecond {
	public static void main(String[] args) {
		int[] arr = {10,50,60,20,30,80,90,40,100,70};
		mergeSort(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void mergeSort(int[] arr) {
		int n = arr.length;
		
		if (n <2)
			return;
		int mid = n/2;
		//System.out.println("\n\nlength of mid is: "+mid);
		int[] left = new int[mid];
		int[] right = new int [n-mid];
		//System.out.println("array of mid is: " + arr[mid]);
		//System.out.print("\nleft array: ");
		for (int i=0; i<mid; i++) {
			left[i] = arr[i];
			//System.out.print(left[i] + ", ");
		}
		//System.out.print("\nRight array: ");
		int k=0;
		for (int j=mid; j <n; j++) {
			right[k] = arr[j];
			//System.out.print(right[k] + ", ");
			k++;
		}
		mergeSort(left);
		mergeSort(right);
		merge(arr, left, right);
	}
	
	public static void merge (int[] arr, int[] left, int[] right) {
		int i=0,j=0, k=0;
		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				arr[k] = left[i];
				i++;
			}
			else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		
		while (i <left.length) {
			arr[k] = left[i];
			i++; k++;
		}
		while (j < right.length) {
			arr[k] = right[j];
			j++; k++;
		}
	}
}
