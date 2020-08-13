package greedyAlgo;

import java.util.*;

public class EgyptianFraction {
	
	private static Vector <Integer> v = new Vector<Integer>();

	public static void main(String[] args) {
		int num = 2, den = 3;
		getEgyptianFractions(num, den);
		
		for (int i : v)
			System.out.print("1/"+i + ", ");
	}

	private static void getEgyptianFractions(int num, int den) {		
		if (num == 1) {
			v.add(den);
			return;
		}
		
		int unit_den = (int) Math.ceil((double)den/num);
		v.add(unit_den);
//		System.out.println(unit_den);
//		System.out.println((num*unit_den) - den + " " +  den*unit_den);
		int gcd = calculateGCD((num*unit_den) - den, den*unit_den);
		getEgyptianFractions(((num*unit_den) - den)/gcd, (den*unit_den)/gcd);	
	}

	private static int calculateGCD(int a, int b) {
		if (b == 0)
			return a;
		return calculateGCD(b, a%b);
	}

}
