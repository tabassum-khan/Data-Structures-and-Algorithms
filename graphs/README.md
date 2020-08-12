# Graph

## Introduction

- Graphs are mathematical structures that represent pairwise relationships between objects. 
- A graph is a flow structure that represents the relationship between various objects. It can be visualized by using the following two basic components:
    - **Nodes:** Nodes are entities whose relationships are expressed using edges. If a graph comprises 2 nodes A and B and an undirected edge between them, then it expresses a bi-directional relationship between the nodes and edge.

    - **Edges:** Edges are the components that are used to represent the relationships between various nodes in a graph. An edge between two nodes expresses a one-way or two-way relationship between the nodes.


## Types of nodes

**1. Root node:** The root node is the ancestor of all other nodes in a graph. It does not have any ancestor. Each graph consists of exactly one root node. Generally, you must start traversing a graph from the root node.

**2. Leaf nodes:** In a graph, leaf nodes represent the nodes that do not have any successors. These nodes only have ancestor nodes. They can have any number of incoming edges but they will not have any outgoing edges.


## Types of graphs

**1. Undirected Graph:**
> An undirected graph is a graph in which all the edges are bi-directional i.e. the edges do not point in any specific direction.

![Undirected Graph](/assets/undirected_graph.jpg)

**2. Directed Graph:**
> A directed graph is a graph in which all the edges are uni-directional i.e. the edges point in a single direction.

![Directed Graph](/assets/directed_graph.jpg)

**3. Weighted:**
> In a weighted graph, each edge is assigned a weight or cost. Consider a graph of 4 nodes as in the diagram below. As you can see each edge has a weight/cost assigned to it. If you want to go from vertex 1 to vertex 3, you can take one of the following 3 paths:

> 1 -> 2 -> 3
> 
> 1 -> 3
> 
> 1 -> 4 -> 3
>
> Therefore the total cost of each path will be as follows: - The total cost of 1 -> 2 -> 3 will be (1 + 2) i.e. 3 units - The total cost of 1 -> 3 will be 1 unit - The total cost of 1 -> 4 -> 3 will be (3 + 2) i.e. 5 units

![Weighted Graph](/assets/weighted_graph.jpg)


**4. Cyclic:**
> A graph is cyclic if the graph comprises a path that starts from a vertex and ends at the same vertex. That path is called a cycle. An acyclic graph is a graph that has no cycle.

**5. Acyclic Graph: (Tree)** 
> A **tree** is an undirected graph in which any two vertices are connected by only one path. A tree is an acyclic graph and has N - 1 edges where N is the number of vertices. Each node in a graph may have one or multiple parent nodes. However, in a tree, each node (except the root node) comprises exactly one parent node.

###### Note: A root node has no parent. A tree cannot contain any cycles or self loops, however, the same does not apply to graphs.

![Tree Graph](/assets/tree_graph.jpg)

## Design and Implementation

### Adjacency Matrix

- Adjacency Matrix is a 2D array of size V x V where V is the number of vertices in a graph.
- Let the 2D array be adj[][], a slot adj[i][j] = 1 indicates that there is an edge from vertex i to vertex j. 
- Adjacency matrix for undirected graph is always symmetric. Adjacency Matrix is also used to represent weighted graphs. 
- If adj[i][j] = w, then there is an edge from vertex i to vertex j with weight w.

![Adjacency Matrix](/assets/adjacency_matrix.png)

- **Pros:** 
Removing an edge takes O(1) time. Queries like whether there is an edge from vertex ‘u’ to vertex ‘v’ are efficient and can be done O(1).

- **Cons:**
Consumes more space O(V^2). Even if the graph is sparse(contains less number of edges), it consumes the same space. Adding a vertex is O(V^2) time.

### Adjacency List

- An array of lists is used. The size of the array is equal to the number of vertices. 
- Let the array be an array[]. An entry array[i] represents the list of vertices adjacent to the ith vertex. 
- This representation can also be used to represent a weighted graph. The weights of edges can be represented as lists of pairs.

![Adjacency List](/assets/adjacency_list.png)

- **Pros:** 
Saves space O(|V|+|E|) . In the worst case, there can be C(V, 2) number of edges in a graph thus consuming O(V^2) space. Adding a vertex is easier.

- **Cons:**
Queries like whether there is an edge from vertex u to vertex v are not efficient and can be done O(V).
