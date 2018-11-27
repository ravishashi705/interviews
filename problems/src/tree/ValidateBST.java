package tree;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 *  Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

Example 1:

Input:
    2
   / \
  1   3
Output: true
 *
 */
public class ValidateBST {
	
	private static Integer previousVal = null;
	
	public static boolean isValidBST(TreeNode root) {
		if(root == null)
			return true;
		
		if(!isValidBST(root.left)) {
			return false;
		}
		
		if(previousVal != null && root.val <= previousVal) {
			return false;
		}
		
		previousVal = root.val;  // update the previous value
		
		return isValidBST(root.right);
	}

	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		System.out.println(isValidBST(root)); // true
	}
}
