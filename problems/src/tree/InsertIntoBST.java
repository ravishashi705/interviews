package tree;

/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
 * Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

For example, 

Given the tree:
        4
       / \
      2   7
     / \
    1   3
And the value to insert: 5

 */

public class InsertIntoBST {

	public static TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		if (val < root.val) {
			root.left = insertIntoBST(root.left, val);
		} else if (val > root.val) {
			root.right = insertIntoBST(root.right, val);
		} else {
			root.val = val;
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(7);
		insertIntoBST(root, 5);
	}

	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		private TreeNode(int value) {
			this.val = value;
		}
	}
}
