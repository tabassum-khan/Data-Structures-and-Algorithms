package beginner;

public class CountOccurences {

	public static void main(String[] args) {
		int[] arr = {10,56,10,56,10,10,24};
		int n = arr.length;
		int element = 100000;
		int count = countOccurences(arr, n , element);
		System.out.println("count : " + count);
	}
	
	private static int countOccurences(int []a, int n, int elem) {
		if (n<=0)
			return 0;
		if (a[n-1]==elem)
			return 1+ countOccurences(a, n-1, elem);
		return countOccurences(a, n-1, elem);
	}
}
