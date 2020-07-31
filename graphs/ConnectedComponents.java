package graphs;

import java.util.*;

public class ConnectedComponents {
	static int n = 10;
	static boolean[] visited = new boolean[n];
	static int[] components = new int[n];
	static ArrayList<ArrayList<Integer>> adj_list = new ArrayList<ArrayList<Integer>>();
		
	static class Graph {
		Graph(){
			for (int i=0; i<n; i++)
				adj_list.add(new ArrayList<Integer>());
		}
	}

	private static void addEdge (int u, int v) {
		adj_list.get(u).add(v);
		adj_list.get(v).add(u);
	}
	
	private static void connectedComponents() {
		int count = 0;
		
		for (int i=0; i<n; i++)
			if (!visited[i])
				DFS(i, ++count);
	}
	
	private static void DFS(int i, int count) {
//		System.out.println(i);
		visited[i] = true;
		components[i] = count;
		
		for (int next : adj_list.get(i))
			if (!visited[next])
				DFS(next, count);
	}
	
	public static void main(String[] args) {
	
		Graph g = new Graph();
		
		//Adding edges
				addEdge(0, 1); 
		        addEdge(0, 4); 
		        addEdge(1, 2); 
		        addEdge(1, 3); 
		        addEdge(1, 4); 
		        addEdge(2, 3); 
		        addEdge(3, 4); 
		        
		        
		        addEdge(6, 5); 
		        addEdge(7, 9); 
		        addEdge(8, 9); 
		        addEdge(7, 5); 
		        addEdge(6, 7); 
		        
		        for (int i=0; i<adj_list.size(); i++) {
					System.out.print("Vertex " + i + " --> ");
					//loops through the edges
					for (int curr : adj_list.get(i))
						System.out.print(curr + ", ");
					
					System.out.println();
				}
		        		        
		        connectedComponents();
		        
		        System.out.println(Arrays.toString(components));
		        
		        
//		 for (int i=0; i<v; i++)
//			 System.out.println(components[i]);
		
	}

}
