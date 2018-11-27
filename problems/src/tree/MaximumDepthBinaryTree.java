package tree;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *
 */
public class MaximumDepthBinaryTree {

	public static int height(TreeNode root) {
		return root == null ? 0 : 1 + Math.max(height(root.left), height(root.right));
	}

	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int data) {
			this.val = data;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		System.out.println(height(root));
	}
}
