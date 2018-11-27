package tree;

/**
 * https://leetcode.com/problems/balanced-binary-tree/description/
 * 
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

    a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7

Return true.
 *
 */
public class BalancedBinaryTree {
	/*
	 * Solution : Use recursion, calculate the height difference recursively
	 * Runtime : O(N), Space : O(1)
	 */
	private static boolean isBalanced = true;
	
	public static boolean isBalanced(TreeNode root) {
      if(root == null)
      		return true;
      height(root);
      return isBalanced;
   }
	
	private static int height(TreeNode node) {
		if(node == null)
			return 0;
		int leftHeight = height(node.left);
		int rightHeight = height(node.right);
		
		if(Math.abs(leftHeight - rightHeight) > 1) {  // if difference > 1, update to FALSE
			isBalanced = false;
		}
		return 1 + Math.max(leftHeight, rightHeight);  // return height
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(isBalanced(root));
	}
	
	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode(int data) {
			this.val = data;
		}
	}

}
