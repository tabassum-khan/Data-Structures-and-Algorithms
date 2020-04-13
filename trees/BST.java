package trees;


public class BST {
	
	static TreeNode root;
	
	BST(){
		root = null;
	}
	
	BST (int data){
		root = new TreeNode (data);
	}
	
	
	public boolean isEmpty () {
		return root == null;
	}
	
	
	/*************************************	 	INSERT 	*******************************************/
	public void add(int data) {
		if (isEmpty()) {
			root = new TreeNode(data);
			return;
		}
		else
			insert(root, data);		
	}//end add();
	
	
	public TreeNode insert (TreeNode temp, int data) {
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
	
	
	/*************************************	 	SEARCH 	*******************************************/
	public TreeNode search (int data) {
		return searchNode(root, root, data);			
	}//end search()
	
	
	public TreeNode searchNode(TreeNode temp, TreeNode prev, int data) {
		
		if (temp == null || temp.data == data) {
			return temp;
		}
		else if (data < temp.data)
			return searchNode(temp.left, temp, data);
		else
			return searchNode(temp.right, temp, data);
	}//end searchNode()
	
	
	/*************************************	 	DELETE 	*******************************************/
	public void delete (int data) {
		deleteNode (root, data);
	}
	
	public TreeNode deleteNode (TreeNode temp, int data) {
		if (temp == null)
			return temp;
		else if (data < temp.data)
			temp.left = deleteNode(temp.left, data);
		else if (data > temp.data)
			temp.right = deleteNode(temp.right, data);
		
		//data found;
		else {
			
			//0 or 1 child
			if (temp.left == null)
				return temp.right;
			else if (temp.right == null)
				return temp.left;
			
			//2 children
			temp.data = maxValue (temp.left);
			temp.left = deleteNode(temp.left, temp.data);
		}
		
		return temp;
	}
	
	public int maxValue (TreeNode temp) {
		int max = root.data;
		while (temp.right !=null) {
			max = temp.right.data;
			temp = temp.right;
		}
		System.out.println(max);
		return max;
	}
	
	/*************************************	 	TRAVERSALS 	*******************************************/
	public void inorder (TreeNode temp) {
		if (temp == null) 
            return; 
       
        inorder(temp.left); 
        System.out.print(temp.data+" "); 
        inorder(temp.right); 
	}
	
	public void print() {
		if (isEmpty()) {
			System.out.println("No Nodes in the Tree");
			return;
		}
		
		inorder(root);
	}
	
	public static void main(String[] args) {
		BST tree = new BST();
		
		tree.print();
		
		tree.add(5);
		tree.add(4);
		tree.add(2);
		tree.add(3);
		tree.add(9);
		tree.add(7);
		tree.add(8);
		tree.add(12);
		tree.add(1);
		tree.add(6);
		
		System.out.println("Root: " + root.data);
		
		tree.print();
		
		tree.search(4);
		//System.out.println("\nPrev 4: " + prev.data);
		tree.search(19);
		//System.out.println("\nPrev 19: " +prev.data);
		tree.search(5);
		//System.out.println("Prev 5: " + prev.data);
		
		tree.delete(9);
		tree.print();
		
		
	}

}
