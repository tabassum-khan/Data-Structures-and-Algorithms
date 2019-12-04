package searching;
//Java program to demonstrate insert operation in binary search tree 
class BinarySearchTree { 

	/* Class containing left and right child of current node and key value*/
	class Node { 
		int key; 
		Node left, right; 

		public Node(int item) { 
			key = item; 
			left = right = null; 
		} 
	} 

	// Root of BST 
	static Node root; 

	// Constructor 
	BinarySearchTree() { 
		root = null; 
	} 

	// This method mainly calls insertRec() 
	
	Boolean search (Node root, int key) {
		if (root==null)
			return false;
		else if (key==root.key)
			return true;
		else if (key>root.key)
			return search(root.right, key);
		return search(root.left, key);
	}
	
	void insert(int key) { 
		root = insertRec(root, key);
	} 
	
	/* A recursive function to insert a new key in BST */
	Node insertRec(Node temp, int key) { 

		/* If the tree is empty, return a new node */
		if (temp == null) { 
			temp = new Node(key); 
			return temp; 
		} 

		/* Otherwise, recur down the tree */
		if (key < temp.key) 
			temp.left = insertRec(temp.left, key); 
		else if (key > temp.key) 
			temp.right = insertRec(temp.right, key); 

		/* return the (unchanged) node pointer */
		return temp; 
	} 
	
	 // This method mainly calls deleteRec() 
    void deleteKey(int key) 
    { 
        root = deleteRec(root, key); 
    } 
  
    /* A recursive function to insert a new key in BST */
    Node deleteRec(Node root, int key) 
    { 
        /* Base Case: If the tree is empty */
        if (root == null)  return root; 
  
        /* Otherwise, recur down the tree */
        if (key < root.key) 
            root.left = deleteRec(root.left, key); 
        else if (key > root.key) 
            root.right = deleteRec(root.right, key); 
  
        // if key is same as root's key, then This is the node 
        // to be deleted 
        else
        { 
            // node with only one child or no child 
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
  
            // node with two children: Get the inorder successor (smallest 
            // in the right subtree) 
            root.key = findMin(root.right); 
  
            // Delete the inorder successor 
            root.right = deleteRec(root.right, root.key); 
        } 
  
        return root; 
    } 
  

	// This method mainly calls InorderRec() 
	void inorder() { 
	inorderRec(root); 
	} 

	// A utility function to do inorder traversal of BST 
	void inorderRec(Node root) { 
		if (root != null) { 
			inorderRec(root.left); 
			System.out.print(root.key + ", "); 
			inorderRec(root.right); 
		} 
	} 
	
	// A utility function to do preorder traversal of BST 
		void preorder(Node root) { 
			if (root != null) { 
				System.out.print(root.key + ", ");
				inorderRec(root.left); 
				inorderRec(root.right); 
			} 
		} 
		
		// A utility function to do postorder traversal of BST 
		void postorder(Node root) { 
			if (root != null) {  
				inorderRec(root.left); 
				inorderRec(root.right); 
				System.out.print(root.key + ", ");
			} 
		} 
		
		int findMin(Node root) {
			if (root.left==null)
				return root.key;
			return findMin(root.left);
		}
		
		int findMax(Node root) {
			if (root.right==null)
				return root.key;
			return findMax(root.right);
		}

	// Driver Program to test above functions 
	public static void main(String[] args) { 
		BinarySearchTree tree = new BinarySearchTree(); 

		/* Let us create following BST 
			50 
		/	 \ 
		30	 70 
		/ \ / \ 
	20 40 60 80 */
		tree.insert(50); 
		tree.insert(30); 
		tree.insert(20); 
		tree.insert(40); 
		tree.insert(70); 
		tree.insert(60); 
		tree.insert(80); 
		
		//System.out.println("root: " + root.key + " left " + root.left.key + " right " + root.right.key);
		
		System.out.println("Inorder traversal of the BST "); 
		tree.inorder(); 
		
		System.out.println("\n\nPreorder traversal of the BST "); 
		tree.preorder(root);
		
		System.out.println("\n\nPostorder traversal of the BST "); 
		tree.postorder(root);
		
		System.out.println("\n\nFind Minimum: "); 
		System.out.println(tree.findMin(root));
		
		System.out.println("\nFind Maximum: "); 
		System.out.println(tree.findMax(root));
		
		System.out.println("\nSearch a value: ");
		if (tree.search(root, 50))
			System.out.println("Found");
		else
			System.out.println("Not found");
		
		
		tree.deleteKey(50);
		tree.deleteKey(10);
		
		System.out.println("\nInorder traversal of the BST "); 
		tree.inorder(); 
		
		tree.insert(10);
		System.out.println("\n\nInorder traversal of the BST "); 
		tree.inorder(); 
		
		
	} 
} 
//This code is contributed by Ankur Narain Verma 
