package greedyAlgo;

import java.util.*;

class Activity{
	int start; 
	int finish;
	
	Activity(int s, int f){
		this.start = s;
		this.finish = f;
	}
} 	

public class ActivitySelecionProblem {
	
	public static void selectActivity(ArrayList<Activity> a) {
		Collections.sort(a, new Comparator<Activity>() {
			@Override
			public int compare(Activity o1, Activity o2) {
				return o1.finish - o2.finish;
			}
		});		
		int  last_activity = 0;
		Vector<Activity> v = new Vector<Activity>();
		v.add(a.get(0));
		
		for(int i=1; i<a.size(); i++) {			
			if (a.get(i).start >= a.get(last_activity).finish) {
				v.add(a.get(i));
				last_activity = i;
			}
		}
		
		System.out.println(v.size());
		
		for (int i=0; i<v.size(); i++)
			System.out.print("{" + v.get(i).start + ", " + v.get(i).finish + "} ");
		System.out.println();
 	}

	public static void main(String[] args) {
		int[][] arr= {{5, 9}, {1, 2}, {3, 4}, {0, 6}, {5, 7}, {8, 9}}; 
		
		ArrayList<Activity> activity = new ArrayList<Activity>();
		
		for (int i=0; i<arr.length; i++)
			activity.add(new Activity(arr[i][0], arr[i][1]));
		
		selectActivity(activity);
	}

}
