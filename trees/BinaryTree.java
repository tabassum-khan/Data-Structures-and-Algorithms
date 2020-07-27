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
	
	
	/******************************************		DELETE		**************************************************************/
	
	public TreeNode delete (TreeNode temp, int x) { 	
		if (temp == null)
			return null;
		if (temp.left == null && temp.right == null)
			if (temp.data == x) 
				return null;
		else
			return temp;
		
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
			
			if (temp == last) {
				temp = null;
				return;
			}
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
	
	
	/******************************************		TRAVERSAL		**************************************************************/
	
	public void inorder (TreeNode temp) {
		if (temp == null) 
            return; 
       
        inorder(temp.left); 
        System.out.print(temp.data+" "); 
        inorder(temp.right); 
	}
	
	
	/**	
	 * finding deepmost node 
	 */
	/***
	 
	 int maxlevel = -1;
	 TreeNode res = null;
	public void inorder (TreeNode temp, level) {
		if (temp == null) 
            return; 
       
        inorder(temp.left, level); 
        inorder(temp.right, ++level);
        
         if (level > maxlevel){
         	maxlevel = level;
         	res = temp;
         }
	}
	
	***/
	

	/******************************************		MAIN UTILITY FUNCTION		**************************************************************/
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree ();
//		BFS bfs = new BFS();
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
			int data = sc.nextInt();
			bt.insert(root, data);
		}
		
		bt.inorder(root);
		
		root = bt.delete(root, 30);
		System.out.println();
		bt.inorder(root);
////		bfs.bfsTraversal(root);
//		System.out.println();
//		bt.inorder(root);
//		
		sc.close();
	}

}
