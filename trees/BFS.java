package trees;

import java.util.*;;

public class BFS {
	
	public void bfsTraversal(TreeNode root) {
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		TreeNode temp = null;
		
		while(!q.isEmpty()) {
			temp = q.peek();
			q.remove();
			
			if (temp.left != null)
				q.add(temp.left);
			
			if (temp.right != null)
				q.add(temp.right);
			
			System.out.print(temp.data + " ");
			
		}
	}

	public static void main(String[] args) {
		BST tree = new BST(5);
		tree.add(3);
		tree.add(4);
		tree.add(2);
		tree.add(1);
		tree.add(9);
		tree.add(7);
		tree.add(8);
		tree.add(6);
		tree.add(10);
		
		System.out.println("Inorder Traversal: ");
		tree.print();
		
		System.out.println("\n\nBFS Traversal:");
		
		BFS bfs = new BFS();		
		bfs.bfsTraversal(BST.root);
		//System.out.println(BST.root.data);
		
	}

}
