package tree;

/**
 *  https://leetcode.com/problems/symmetric-tree/description/
 *  
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 *
 */
public class SymmetricTree {

	public static boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isSymmetric(root.left, root.right);
	}

	private static boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		
		if (left == null || right == null)
			return false;
		
		if (left.val != right.val)
			return false;
		
		return isSymmetric(left.left, right.right) 
				&& isSymmetric(left.right, right.left);
	}

	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		private TreeNode(int value) {
			this.val = value;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		System.out.println(isSymmetric(root));
	}

}
