package graphs;

import java.util.ArrayList;
import java.util.Iterator;

public class CountPaths {

	public static void main(String[] args) {
		AdjacencyList adj_obj = new AdjacencyList();
		
		int v = 5;
		
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		
		//add lists for every vertex. The list will contain edges.
		for (int i=0; i<v; i++)
			arr.add(new ArrayList<Integer>());
		
		//Adding edges
		adj_obj.addEdge(arr, 0, 1); 
		adj_obj.addEdge(arr, 0, 4); 
		adj_obj.addEdge(arr, 1, 2); 
		adj_obj.addEdge(arr, 1, 3); 
		adj_obj.addEdge(arr, 1, 4); 
		adj_obj.addEdge(arr, 2, 3); 
		adj_obj.addEdge(arr, 3, 4); 
        
        System.out.println("Adjacency List of:");
        adj_obj.printGraph(arr);
        
        
        System.out.print("Count of paths between 0 and 4: ");
        System.out.println(DFS(0, 4, 0, arr));
	}
	
	public static int DFS(int u, int v, int count, ArrayList<ArrayList<Integer>> adj) {	
		if (u == v)
			++count;
		else {
			for(int curr : adj.get(u)) {
				count = DFS(curr, v, count, adj);
			}
		}
		
		return count;
	}
	
}