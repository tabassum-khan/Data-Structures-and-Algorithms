package graphs;

import java.util.*;

public class Graph_SetsandHash {
	private HashMap<Integer, List<Integer>> map;
	
	Graph_SetsandHash(int v){
		map = new HashMap<Integer, List<Integer>>();
		
		for(int i=0; i<v; i++)
			map.put(i,  new LinkedList<Integer>());
	}
	
	public void addEdge(int u, int v) {
		map.get(u).add(v);
		map.get(v).add(u);
	}
	
	public boolean searchEdge(int u, int v) {
		if (map.get(u).contains(v))
			return true;
		return false;	
	}
	
	public void printGraph(int v) {
		for (int i=0; i<v; i++) {
			System.out.print(i + " --> ");
			for (int j=0; j<map.get(i).size(); j++)
				System.out.print(map.get(i).get(j) + ", ");
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		 int v = 5;
		 Graph_SetsandHash g = new Graph_SetsandHash(v);
		 
		 g.addEdge(0, 1); 
		 g.addEdge(0, 4); 
		 g.addEdge(1, 2); 
		 g.addEdge(1, 3); 
		 g.addEdge(1, 4); 
		 g.addEdge(2, 3); 
		 g.addEdge(3, 4); 
		 
		 System.out.println(g.searchEdge(2, 1));
		 System.out.println(g.searchEdge(0, 3)); 
		 
		 System.out.println();
		 
		 g.printGraph(v);
	}
}


