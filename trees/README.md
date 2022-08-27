# Tree
> 💡 On Notion → [Trees](https://www.notion.so/Trees-0a0045dc42f542cdbeb16d36f0874011)


## Introduction

- In computer science, a tree is a widely used abstract data type (ADT) that simulates a hierarchical tree structure, with a root value and subtrees of children with a parent node, represented as a set of linked nodes.

- A tree data structure can be defined recursively as a collection of nodes (starting at a root node), where each node is a data structure consisting of a value, together with a list of references to nodes (the "children"), with the constraints that no reference is duplicated, and none points to the root.


## Terminologies

1. **Node** : A node is a structure which may contain a value or condition, or represent a separate data structure (which could be a tree of its own). Each node in a tree has zero or more child nodes.
2. **Root Node** : The topmost node is called root of the tree.
3. **Children Nodes** : The elements that are directly under an element are called its children. 
4. **Parent Node** : The element directly above the nodes is called its parent.
5. **Siblings** : Elements that have same parent are called siblings.
6. **Leaf Nodes** : The elements with no children are called leaves.
7. **Subtree** : A subtree is a portion of a tree data structure that can be viewed as a complete tree in itself.
8. **Depth of a node** : Number of edges from root to the node.
9. **Height of a node** : Number of edges from the node to the deepest leaf. Height of the tree is the height of the root.

A generic tree is shown in the figure below:

![Generic Tree Representation](/assets/tree.png)

> Here, 2 is a root node. 5, 11, and 4 are leaves. 2, 10 and 6 have the same parent node 7 and are the children of node 7. Hence, 2, 10, and 6 are also siblings.
>
> Here, Let A = subtree [5, 9, and 4]. And B = subtree [7, 2, 10, 6, 5, 11] . Both A and B are subtree of 2 and share the same parent 2. A and B are siblings.


## Design and Implementation

A simple binary tree node in java can be constructed as below. A node will have:
  - Key value
  - Left pointer 
  - Right pointer

The constructor will define and initialise the node and a Tree Node is created. The tree Node can be represented as below:

>          | Left | key | Right|
>              /             \
>            left           right
>           subtree        subtree
                    
  
```
class Node 
{ 
    int key; 
    Node left, right; 
  
    public Node(int item) 
    { 
        key = item; 
        left = right = null; 
    } 
} 
```

## Types of Trees

There are a lot of different types of trees. Some of them are going to be discussed here.

1. [Binary Tree](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/trees/binary_tree.md)
2. [Binary Search Trees (BST)](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/trees/binary_search_tree.md)
3. [Heap](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/trees/heap.md)
4. [Augmented Trees](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/trees/augmented_trees.md)
5. [Trie](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/trees/trie.md)
