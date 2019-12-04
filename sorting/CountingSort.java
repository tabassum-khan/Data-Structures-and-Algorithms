package sorting;

public class CountingSort {
	public static int MAX = 256;
	public static void main(String[] args) {
		int[] arr = {1,2,1,4,2,5,7,2};
		countSort(arr);
		System.out.println("\nSorted Array: ");
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + ", ");
		
		char c_arr[] = {'g', 'e', 'e', 'k', 's', 'f', 'o', 
                'r', 'g', 'e', 'e', 'k', 's'
                };
		countSort(c_arr);
		System.out.println("\nSorted Char Array: ");
		for(int i=0; i<c_arr.length; i++)
			System.out.print(c_arr[i] + ", ");
	}
	
	
	public static void countSort(int[] arr){
		int[] count = new int[10];
		int[] sort_arr = new int[arr.length];
		
		for (int i=0; i<arr.length; i++)
			count[arr[i]]++;
		
		for (int i=1; i<10; i++) {
			count[i] =count[i] + count[i-1];
		}
		System.out.println("count arr:");
		for (int i =0; i<10;i++) {
			System.out.print(count[i] + ", ");
		}
		
		for (int i=0; i<arr.length; i++) {
			sort_arr[count[arr[i]]-1] = arr[i];
			count[arr[i]]--;			
		}
		for (int i =0; i<arr.length;i++) {
			arr[i]=sort_arr[i];
		}

	}
	
	public static void countSort(char[] arr){
		int[] count = new int[256];
		char[] sort_arr = new char[arr.length];
		
		for (int i=0; i<arr.length; i++)
			count[arr[i]]++;
		for (int i=1; i<256; i++) {
			count[i] =count[i] + count[i-1];
		}
		System.out.println("count arr:");
		for (int i =0; i<256;i++) {
			System.out.print(count[i] + ", ");
		}
		
		for (int i = arr.length-1; i>=0; i--) {
			sort_arr[count[arr[i]]-1] = arr[i];
			count[arr[i]]--;			
		}
		for (int i =0; i<arr.length;i++) {
			arr[i]=sort_arr[i];
		}

	}
}
