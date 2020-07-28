#  Augmented Trees

## Introduction

- Augmenting data structure means adding some extra information to the existing data structure so that the data structure can be implemented efficiently.


## Augmentation strategy

Following are the steps which are needs to be followed when we want to augment a data structure.

- Firstly choose a data structure which has to be augmented.
- Then find out the additional information which is needed to be added and which also support the algorithm.


## Design and Implementation 

#### Problem Statemement:
**Given the root of a binary search tree and K as input, find K-th smallest element in BST.
For example, in the following BST, if k = 3, then the output should be 10, and if k = 5, then the output should be 14.**

#### Algorithm: 
**Using Augmented BST**
- The idea is to maintain the rank of each node. We can keep track of elements in the left subtree of every node while building the tree. 
- Since we need the K-th smallest element, we can maintain the number of elements of the left subtree in every node.

- **Time Complexity** : O(h) where h = height of BST.
- **Space Complexity** : O(h)

Augmented binary search tree is fully implemented [here](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/trees/KthSmallestElementAugmentedBST.java)
