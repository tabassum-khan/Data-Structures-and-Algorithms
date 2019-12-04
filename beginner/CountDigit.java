package beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountDigit {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		int count = countDigit(num, num.length());
		System.out.println(count);
		int number = Integer.parseInt("" + num);
		//System.out.println(number);
		int countDigit = cDigit(number);
		System.out.println(countDigit);
	}
	private static int countDigit(String num, int n) {
		if(n==0)
			return 0;
		if (Integer.parseInt("" + num.charAt(n-1)) == 7)
			return 1+countDigit(num, n-1);
		return countDigit(num, n-1);
	}
	
	private static int cDigit(int num) {
		if (num==0)
			return 0;
		if(num%10==7)
			return 1+ cDigit(num/10);
		return cDigit(num/10);
	}
}
