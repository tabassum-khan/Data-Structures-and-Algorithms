/**
 * UNIRECTED GRAPHS
 * @author tabassum
 *
 */

package graphs;

import java.util.*;

public class AdjacencyList {

	public static void main(String[] args) {
		int v = 5;
		
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		
		//add lists for every vertex. The list will contain edges.
		for (int i=0; i<v; i++)
			arr.add(new ArrayList<Integer>());
		
		//Adding edges
		addEdge(arr, 0, 1); 
        addEdge(arr, 0, 4); 
        addEdge(arr, 1, 2); 
        addEdge(arr, 1, 3); 
        addEdge(arr, 1, 4); 
        addEdge(arr, 2, 3); 
        addEdge(arr, 3, 4); 
        
        System.out.println("Adjacency List of:");
        printGraph(arr);
		
	}
	
	public static void addEdge(ArrayList<ArrayList<Integer>> arr, int u, int v) {
		arr.get(u).add(v); //an edge directed from u to v
//		arr.get(v).add(u); //an edge directed from v to u
	}
	
	
	public static void printGraph(ArrayList<ArrayList<Integer>> a) {
		//loops through all the vertices
		for (int i=0; i<a.size(); i++) {
			System.out.print("Vertex " + i + " --> ");
			//loops through the edges
			for (int curr : a.get(i))
				System.out.print(curr + ", ");
			
			System.out.println();
		}
	}
}
