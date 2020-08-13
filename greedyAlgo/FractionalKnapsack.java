package greedyAlgo;

import java.util.*;

class Item {
	int weight;
	int value;
	int cost;
	int index;
	Item (int w, int v,int i){
		weight = w;
		value = v;
		index = i;
		cost = value/weight;
	}
	public String toString () {
		return index + ":: " +weight + "; " + value + "; " + cost;
	}
}

class MyComp implements Comparator <Item>{
	@Override
	public int compare(Item o1, Item o2) {
		if (o1.cost<o2.cost)
			return 1;
		else 
			return -1;
	}
}

public class FractionalKnapsack {
	public static int MaxProfit(int[] weight, int[] profit, int capacity) {
		int n = weight.length;
		int maxProfit = 0;
		ArrayList <Item> arr = new ArrayList <Item>(n);
		
		//adding items to collection
		for (int i=0; i<n; i++) {
			arr.add (new Item(weight[i], profit[i], i));
		}
		
		//sorting collection in reverse order using user defined comparator
		Collections.sort(arr, new MyComp());
		
		//displaying elements in the arraylist
		for (Item element:arr ) {
			System.out.println(element);
		}
		
		//calculating max profit 
		for (Item i:arr) {
			int wt = (int) i.weight;
			int val = (int) i.value;
			
			if (capacity - wt >=0) {
				capacity -= wt;
				maxProfit += val;
			}
			else {
				double fraction = (double) capacity/(double) wt;
				maxProfit += fraction * val;
				break;
			}
		}
		return maxProfit;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter capacity: ");
		int capacity = sc.nextInt();
		int[] weight = {10, 40, 20, 30};		
		int[] profit = {60, 40, 100, 120};
		
		int maxProfit = MaxProfit(weight, profit, capacity);
		System.out.println("Max Profit is: " + maxProfit);
		sc.close();
	}

}
