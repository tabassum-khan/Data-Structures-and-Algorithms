package sorting;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = {10,50,60,20,30,80,90,40,100,70};
		int[] a = mergeSort(arr, 0, arr.length-1);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	public static int[] mergeSort(int[] arr, int left, int right) {
		//System.out.println("In merge Sort: ");
		if (left < right) {
			int mid = (left + right)/2;
			
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			
			merge(arr, left, mid, right);
		}
		return arr;
	}
	
	public static void merge(int[] arr, int left, int mid, int right) {
		
		int nL = mid - left + 1;
		int nR = right - mid;
		
		int[] leftArr = new int[nL];
		int[] rightArr = new int[nR];
		
		for(int i=0; i<nL; i++) {
			leftArr [i] = arr [left + i];
		}
		for (int j=0; j<nR; j++) {
			rightArr[j] = arr[mid +1 +j];
		}
		
		int i=0, j=0,k=left;
		
		while(i<nL && j<nR) {
			if (leftArr[i] <= rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
			}
			else {
				arr[k] = rightArr[j];
				j++;
			}
			k++;
		}
		while (i < nL) {
			arr[k] = leftArr[i];
			i++; k++;
		}
		while (j < nR) {
			arr[k] = rightArr[j];
			j++; k++;
		}
	}
}
