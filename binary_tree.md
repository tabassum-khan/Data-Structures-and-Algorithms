# Binary Tree

## Introduction

- A tree whose elements have at most 2 children is called a binary tree. Since each element in a binary tree can have only 2 children, we typically name them the left and right child.

![Binary Tree](/assets/binary_tree.png)

- **Properties of Binary Tree**

      1. The maximum number of nodes at any level ‘l’ of a binary tree is 2^l. For root, l = 0, number of nodes = 2^0 = 1.
      2. Maximum number of nodes in a binary tree of height ‘h’ is 2^h – 1. If the height of the root is considered as 0, in this convention, the above formula becomes 2 ^ (h+1) – 1.
      3. In a binary tree with nodes 'N' the height of the tree is log(N+1).
      4. A Binary Tree with L leaves has at least log(L) + 1 levels.
      5. In Binary tree where every node has 0 or 2 children, number of leaf nodes is always one more than nodes with two children.
          
## Types of Binary Tree

#### 1. Full Binary Tree

- A Binary Tree is a full binary tree if every node has 0 or 2 children. The following are the examples of a full binary tree. We can also say a full binary tree is a binary tree in which all nodes except leaf nodes have two children.

- In a Full Binary Tree, number of leaf nodes is the number of internal nodes plus 1.
  >  L = I + 1
  >
  > Where L = Number of leaf nodes, I = Number of internal nodes.
  
#### 2. Complete Binary Tree

- A Binary Tree is a complete Binary Tree if all the levels are completely filled except possibly the last level and the last level has all keys as left as possible.


#### 3. Perfect Binary Tree 

- A Binary tree is a Perfect Binary Tree in which all the internal nodes have two children and all leaf nodes are at the same level.
- A Perfect Binary Tree of height h (where height is the number of nodes on the path from the root to leaf) has 2^h – 1 node.


#### 4. Balanced Binary Tree

- A binary tree is balanced if the height of the tree is O(Log n) where n is the number of nodes. 
- For Example, the AVL tree maintains O(Log n) height by making sure that the difference between the heights of the left and right subtrees is almost 1. 
- Red-Black trees maintain O(Log n) height by making sure that the number of Black nodes on every root to leaf paths is the same and there are no adjacent red nodes. 
- Balanced Binary Search trees are performance-wise good as they provide O(log n) time for search, insert and delete.

#### 5. A degenerate (or pathological) tree 

- A tree where every internal node has one child. Such trees are performance-wise same as linked list.


## Design and Implementation

A full implementation of the binary tree is depicted [here](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/trees/BinaryTree.java).
