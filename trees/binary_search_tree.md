# Binary Search Tree
>💡 On Notion → [Binary Search Tree](https://www.notion.so/Binary-Search-Tree-52dbfbf82d334956bae920133229fa73)
>
## **Introduction**
A Binary Search Tree is a node-based binary tree data structure which has the following properties:
> - The left subtree of a node contains only nodes with keys lesser than the node’s key.
> - The right subtree of a node contains only nodes with keys greater than the node’s key.
> - The left and right subtree each must also be a binary search tree.

### Representation of Binary Search Tree

![Binary Search tree Representation](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/raw/master/assets/binary_search_tree.png)

## **Design and Implementation**

### Creation

```java
class TreeNode
{
    int data;
    TreeNode left, right;

    public TreeNode(int item)
    {
        data = item;
        left = right = null;
    }

    public TreeNode(){
    	left = right = null;
    }
}
TreeNode root;
```

### Insertion

- If root is empty, then create a new node and make the root point to the new node.
- Else, follow the BST properties. So, if the data is less than the data of the node, move left.
- If the data is greater than the data of the node, move right.

```java
public TreeNode insert (TreeNode temp, int data) {
	//if root is empty
	if (temp == null) {
		temp = new TreeNode (data);
		return temp;
	}
		
	if (data < temp.data)
		temp.left = insert (temp.left, data);
	else if (data > temp.data)
		temp.right = insert (temp.right, data);
		
	return temp;
}
```

### Search

- If root is empty or root is equal to the search data, then return root.
- Else, follow the BST properties. So, if the data is less than the data of the node, move left.
- If the data is greater than the data of the node, move right.

```java
public TreeNode searchNode(TreeNode temp, TreeNode prev, int data) {
	if (temp == null || temp.data == data) {
		return temp;
	}
	else if (data < temp.data)
		return searchNode(temp.left, temp, data);
	else
		return searchNode(temp.right, temp, data);
}
```

### Delete a Node

- If the tree is empty → return null
- Else following the BST properties, if the data is less than the node, move left else move right.
- Now, we must have found the node that is to be deleted.
- The node can have
    - **No children, a leaf node** → can be deleted by making the node null
        
        ```
                      50                            50
                   /     \         delete(20)      /   \
                  30      70       --------->    30     70
                 /  \    /  \                     \    /  \
               20   40  60   80                   40  60   80
        ```
        
    - **1 child** → then link the parent node to the child and delete the node
        
        ```
        	      50                             50(parent)
                   /     \       delete(30)         /   \
                  30      70     --------->(child)40     70
                    \    /  \                          /  \
                    40  60   80                       60   80
        ```
        
    - **2 children** → Find the inorder successor of the node and we need to replace the node with the inorder successor and then delete the inorder successor.
    	> So, we can either traverse through the right subtree and find the smallest node (last left node in the right substree), replace the node to be deleted with the smallest node and then delete the smallest node.
    	> 
    	> **OR**
    	> 
    	> We can traverse through the left subtree to find the largest node (last right node in left subtree),  replace the node to be deleted with the largest node and then delete the largest node.

        ```
                      50                            60
                   /     \         delete(50)      /   \
                  40      70       --------->    40    70
                         /  \                            \
                        60   80                           80
        ```

```java
public TreeNode deleteNode (TreeNode temp, int data) {
	//if the tree is empty
	if (temp == null)
		return temp;
	else if (data < temp.data)
		temp.left = deleteNode(temp.left, data);
	else if (data > temp.data)
		temp.right = deleteNode(temp.right, data);
	
	//temp will be at the node that is to be deleted;
	else {
		
		//0 or 1 child
		if (temp.left == null)
			return temp.right;
		else if (temp.right == null)
			return temp.left;
		
		//2 children
		temp.data = maxValue (temp.left); //replace the node value with the max value 
		temp.left = deleteNode(temp.left, temp.data); //delete the inorder successor
	}
		
	return temp;
}

// traverse the right subtree
public int maxValue (TreeNode temp) {
	while (temp.right !=null)
		temp = temp.right;
	return temp.right.data;;
}
```

**Optimization to above code for two children case :**

> In the above recursive code, we recursively call delete() for the inorder successor. We can avoid recursive calls by keeping track of the parent node of the successor so that we can simply remove the successor by making the child of a parent NULL. We know that the successor would always be a leaf node or with 1 child.

```java
public TreeNode deleteNode (TreeNode temp, int data) {
	//if the tree is empty
	if (temp == null)
		return temp;
	else if (data < temp.data)
		temp.left = deleteNode(temp.left, data);
	else if (data > temp.data)
		temp.right = deleteNode(temp.right, data);
		
	//temp will be at the node that is to be deleted;
	else {
		
		//0 or 1 child
		if (temp.left == null)
			return temp.right;
		else if (temp.right == null)
			return temp.left;
			
		//2 children
		else{
			TreeNode succParent = temp;
			TreeNode succ = temp.left;
				
	               //find the maximum in the left subtree
			while(succ.right != null){
				succParent = succ;
				succ = succ.right;
			}		

              		// If we have the right successor in the left subtree, then we know that, the successor right will be null since it is the maximum value. 
	      		// Hence, link the right of the succParent to the left of the successor. Thereby deleting the successor but not its left subtree if it has any.
              
	      		// But if we do not have a successor and succParent is temp itself, then it means that succ does not have a right child. 
	      		// And hence, we can safely link left of the succParent to the left of the succ. 
	      		// Now, in this case, succ node is not linked to the tree anymore but this not the node to be deleted. 
	      		// The node to be deleted is succParent. Hence, replace succParent with succ.
				
               		if(succParent != temp)
				succParent.right = succ.left;
			else
				succParent.left = succ.left;
		
			temp.key = succ.key; 									
		}
	}
		
	return temp;
} 
```
