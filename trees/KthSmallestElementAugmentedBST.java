/***
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * @author tabassumm
 *
 */

package trees;


public class KthSmallestElementAugmentedBST {
	private static TreeNode root = null;
	
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		int l_count;
		
		TreeNode(){}
		
		TreeNode(int val){	
			this.val = val;
			left = right = null;
			l_count = 0;
		}
		
		TreeNode(int val, TreeNode left, TreeNode right, int l_count){
			this.val = val;
			this.left = left;
			this.right = right;
			this.l_count = l_count;
		}
	}
	
	public static TreeNode insert (TreeNode temp, int x) {
		//System.out.println(x);
		if (temp == null) {
			return new TreeNode(x);
		}
			
		if (x < temp.val) {
			temp.left = insert(temp.left, x);
			temp.l_count++;
		}
		else if (x>temp.val)
			temp.right = insert(temp.right, x);
		return temp;
	}
	
	/****************	Inserting nodes with the help of loop	*******************/
	
	public static void insertUsingLoop(TreeNode temp, int x) {		
		if (temp == null) {
			root = new TreeNode(x);
			return;
		}
		
		while (temp!=null) {
			if (x < temp.val) {
				if (temp.left == null) {
					temp.left = new TreeNode(x);
					temp.l_count++;
					return;
				}
				temp.l_count++;
				temp = temp.left;
			}
			if (x > temp.val) {
				if (temp.right == null) {
					temp.right = new TreeNode(x);
					return;
				}
				temp = temp.right;
			}
		}
			
	}
	
	/****************	find kth smallest element	*******************/
	
	public static int kthSmallestElement (TreeNode temp, int k) {
		int count = 1 + temp.l_count;
		if (count > k)
			return kthSmallestElement(temp.left, k);
		else if (count < k)
			return kthSmallestElement(temp.right, k-count);
		
		return temp.val;
	}
	
	
	public static void inorder(TreeNode temp) {
		if (temp == null)
			return;
		inorder(temp.left);
		System.out.println(temp.val + " " + temp.l_count);
		inorder(temp.right);
	}

	public static void main(String[] args) {
		Integer[] arr = {5,3,6,2,4,null, null,1};
		
		for (int i=0; i<arr.length; i++)
			if (arr[i] == null)
				continue;
			else
				insertUsingLoop(root, arr[i]);
		
		insertUsingLoop(root, 0);
		
		inorder(root);
		int k = 5;
		int kthSmallest = kthSmallestElement(root, k);
		System.out.println("kth Smallest : " + kthSmallest);
	}

}
