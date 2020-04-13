package trees;

import java.util.*;

public class BinaryTree {
	
	private static TreeNode root;
	
	BinaryTree(){
		root = null;
	}
	
	BinaryTree(int key){
		root = new TreeNode(key);
	}

	/******************************************		INSERT		**************************************************************/
	public void insert(TreeNode temp, int data) {
		
			if (root == null) {
				root = new TreeNode(data);
				return;
			}
		
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
				 
//				 System.out.println(temp.data);
//				 System.out.println(q);
			}			
	}
	
	public void inorder (TreeNode temp) {
		if (temp == null) 
            return; 
       
        inorder(temp.left); 
        System.out.print(temp.data+" "); 
        inorder(temp.right); 
	}
	

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree ();
		BFS bfs = new BFS();
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
			int data = sc.nextInt();
			bt.insert(root, data);
		}
		
		bfs.bfsTraversal(root);
		System.out.println();
		bt.inorder(root);
		
		sc.close();
	}

}
