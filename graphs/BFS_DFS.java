package graphs;

import java.util.*;

class Graph{
	private int v;
	private LinkedList<Integer>[] adj;
	
	Graph(int v){
		this.v = v;
		adj = new LinkedList[v];
		
		for (int i=0; i<v; i++)
			adj[i] = new LinkedList();
	}

	public void addEdge(int u, int v) {
		adj[u].add(v);
	}
	
	public void BFS(int s) {
		boolean[] visited = new boolean[v];
		
		Queue<Integer> q = new LinkedList<Integer>();
		visited[s] = true;
		q.add(s);
		
		while(q.size() != 0) {
			s = q.poll();
			System.out.print(s + " ");
			
			for (int i=0; i<adj[s].size(); i++) {
				int next_node = adj[s].get(i);
				if (!visited[next_node]) {
//					System.out.print(next_node + " ");
					visited[next_node] = true;
					q.add(next_node);
				}
			}
//			System.out.println();
		}
	}
		
	public void DFS(int s, boolean[] dfs_visited) {		
		dfs_visited[s] = true;
		System.out.print(s + " ");
		
		for(int curr : adj[s]) {
			if (!dfs_visited[curr])
				DFS(curr, dfs_visited);
		}
	}
	

	public void iterative_DFS(int s) {	
		boolean[] visited = new boolean[v];
		Stack <Integer> stack = new Stack<Integer>();
		
		visited[s] = true;
		stack.push(s);
		
		while (!stack.isEmpty()) {
			s = stack.pop();
			System.out.print(s + " ");
			
			for (int curr : adj[s]) { 
				if (!visited[curr]) {
					visited[curr] = true;
					stack.push(curr);
				}
			}
		}
		
	}
	
}


public class BFS_DFS {	
		
	public static void main(String[] args) {
		int v = 5;
		Graph g = new Graph(v);
		
		g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 	
        
        System.out.println("BFS Traversal: ");
        g.BFS(2);
        
        System.out.println("\n");
        
        System.out.println("DFS Traversal: ");        
        boolean[] dfs_visited = new boolean[v];
        g.DFS(2, dfs_visited);
        
        System.out.println("\n");
        
                
        System.out.println("\n");
        
        System.out.println("Iterative DFS Traversal: ");  
        g.iterative_DFS(2);
	}

}
