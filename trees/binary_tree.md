# Binary Tree
💡 *On Notion → [Binary Tree](https://www.notion.so/Binary-Tree-19cdd69dec4e4c3eaca01692f853d658)*


## **Introduction**
A binary tree is a hierarchical data structure in which each node has at most two children generally referred as left child and right child.

Each node contains three components:

- Pointer to left subtree
- Pointer to right subtree
- Data element

The topmost node in the tree is called the root. An empty tree is represented by NULL pointer.

## Representation of binary tree

![Binary Tree Representation](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/raw/master/assets/binary_tree.png)

## **Properties**
1. The maximum number of nodes at level $‘l’$ of a binary tree is $2^l$. For root, $l = 0$, number of nodes = $2^0 = 1.$
2. Maximum number of nodes in a binary tree of height ‘h’ is **2^h – 1**. 
When height of the root is considered as 0, in this convention, the above formula becomes **2^(h+1)-1.**
3. In a Binary Tree with N nodes, minimum possible height or minimum number of levels is **log(N+1)**.
4. A Binary Tree with L leaves has at least **log(L) + 1** levels.
5. In Binary tree where every node has 0 or 2 children, number of leaf nodes is always one more than nodes with two children.
    
    > L = T + 1
    > 
    > Where, L = Number of leaf nodes
    > 
    > T = Number of internal nodes with two children


## **Types of Binary Trees**

### **1. Full Binary Tree**

> A Binary Tree is a full binary tree if every node has 0 or 2 children. The following are the examples of a full binary tree. We can also say a full binary tree is a binary tree in which all nodes except leaf nodes have two children.
> 
> - In a Full Binary Tree, number of leaf nodes is the number of internal nodes plus 1 →  L = I + 1
> - Where, L  = Number of leaf nodes, 
> 
> - I = Number of internal nodes

### **2. Complete Binary Tree**

> A Binary Tree is a complete Binary Tree if all the levels are completely filled except possibly the last level and the last level has all keys as left as possible.

### **3. Perfect Binary Tree**

> A Binary tree is a Perfect Binary Tree in which all the internal nodes have two children and all leaf nodes are at the same level.
> 
> A Perfect Binary Tree of height h (where height is the number of nodes on the path from the root to leaf) has **2^h – 1** node. 

### **4. Balanced Binary Tree**

> A binary tree is balanced if the height of the tree is Logn where n is the number of nodes.
> 
> - For Example, the AVL tree maintains O(Logn)  height by making sure that the difference between the heights of the left and right subtrees is almost 1.
> - Red-Black trees maintain O(Logn) height by making sure that the number of Black nodes on every root to leaf paths is the same and there are no adjacent red nodes.
> - Balanced Binary Search trees are performance-wise good as they provide  O(Logn) time for search, insert and delete.

### **5. A degenerate (or pathological) tree**

> A Tree where every internal node has one child. Such trees are performance-wise same as linked list. 

## **Design and Implementation**

### Creation

```java
class TreeNode
{
    int data;
    TreeNode left, right;

    public TreeNode(int item){
        data = item;
        left = right = null;
    }
    
    public TreeNode(){
    	left = right = null;
    }
}
TreeNode root;
```

### Insertion (for a complete binary tree)

- If root is empty, then create a new node and make the root point to the new node.
- Else, Do level order traversal and check if the left or night node is empty .
- If any of them are empty, then create the new node, point it to the new node and return.

```java
public void insert(TreeNode temp, int data) {
		
	//if root is empty, point root to the new node
	if (root == null) {
		root = new TreeNode(data);
		return;
	}

	//if not empty, then traverse(using bst) till the last node to create a balanced binary tree		
	Queue<TreeNode> q = new LinkedList<TreeNode>();
	q.add(temp);
	
	while (!q.isEmpty()) {
		 temp = q.peek();
		 q.remove();
			 
		 if (temp.left == null) {
			temp.left = new TreeNode(data);
			return;
		 }
		 else
			 q.add(temp.left);
				 
		 if (temp.right == null) {
			 temp.right = new TreeNode(data);
			 return;
		 }
		 else
			 q.add(temp.right);
		}			
	}
}
```

### Delete a Node

- If the tree is empty → return null
- If the tree contains only root, then if root.data == x, make it null and return
- Else, do level order traversal till the last node. Meanwhile also check if any of the node’s data is equal to x.
- Now the node that was equal to x, lets call it keyNode. Edit the keyNode data and make it equal to the last node’s data. Delete the last node.
- We dont delete the keyNode because it might contain left or right subtree or both.

```java
public TreeNode delete (TreeNode temp, int x) { 	
	//If tree is empty
	if (temp == null)
		return null;
		
	//If there is only root in the tree
	if (temp.left == null && temp.right == null){
		if (temp.data == x)
			temp = null;
		return temp;
	}
		
	//Level Order traversal
	Queue<TreeNode> q = new LinkedList<TreeNode>();
	q.add(temp);
		
	TreeNode keyNode = null;
	TreeNode last = null;
		
	while (!q.isEmpty()) {
		last = q.peek();
		q.remove();
			
		if (last.data == x)
			keyNode = last;
			
		if (last.left != null)
			q.add(last.left);
		if (last.right != null)
			q.add(last.right);
	}
	
	//Make the keyNode equal to last node before deleting the last node
	int key = last.data;
	deleteLast(last);
	keyNode.data = key;
		
	return temp;
}
	
	
public void deleteLast(TreeNode last) {
	Queue<TreeNode> q = new LinkedList<TreeNode>();
	q.add(root);
		
	TreeNode temp = null;
	
	while(!q.isEmpty()) {
		temp = q.peek();
		q.remove();
			
		// if the node is equal to the last node, then make it null and return
		if (temp == last) {
			temp = null;
			return;
		}
			
		//check if any of the left or right nodes is equal to the last node before adding them to the queue
		if (temp.left != null) {
			if(temp.left == last) {
				temp.left = null;
				return;
			}
			else
				q.add(temp.left);
		}
			
		if (temp.right != null) {
			if(temp.right == last) {
				temp.right = null;
				return;
			}
			else
				q.add(temp.right);
		}
	}
}
```

### **Traversal**

**1. Pre-order traversal**

In this traversal technique the traversal order is root-left-right i.e.

- Process data of root node
- First, traverse left subtree completely
- Then, traverse right subtree

```java
void perorder(TreeNode root){
        if(root != null)
        {
            print(root.data);    //Printf root->data
            preorder(root.left);    //Go to left subtree
            preorder(root.right);     //Go to right subtree
        }
}
```

**2. Post-order traversal**

In this traversal technique the traversal order is left-right-root.

- Process data of left subtree
- First, traverse right subtree
- Then, traverse root node

```java
void postorder(TreeNode root)
    {
        if(root != null)
        {
            postorder(root.left);    //Go to left sub tree
            postorder(root.right);     //Go to right sub tree
            print(root.data);    //Printf root->data
        }
    }
```

**3. In-order traversal**

In in-order traversal, do the following:

- First process left subtree (before processing root node)
- Then, process current root node
- Process right subtree

```java
void inorder(TreeNode root)
    {
        if(root != null)
        {
            inorder(root.left);    //Go to left subtree
            print(root.data);    //Printf root->data
            inorder(root.right);     //Go to right subtree
        }
    }
```

4**. Level Order traversal**

In level order traversal, we traverse the tree level wise

- Create a queue and add the root node
- Loop through the queue and print the node
- Add the left node  and right node if they are not empty

```java
Queue<TreeNode> q = new LinkedList<TreeNode>();
q.add(temp);
			
while (!q.isEmpty()) {
	temp = q.peek();
	System.out.println(temp.data);
	q.remove();
				 
	if (temp.left != null) 
		q.add(temp.left);
				 
	if (temp.right != null)
		q.add(temp.right);
}			
```
