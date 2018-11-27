package tree;

/**
 *  # 543 : https://leetcode.com/problems/diameter-of-binary-tree/
 *  
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
	Example:
	Given a binary tree
          1
         / \
        2   3
       / \     
      4   5    
	Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
	Note: The length of path between two nodes is represented by the number of edges between them
 */
public class DiameterOfTree {

	private static int diameter;

	public static int diameterOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;

		diameter = 1;
		depth(root);
		return diameter - 1;
	}

	private static int depth(TreeNode node) {
		if (node == null)
			return 0;
		int leftDepth = depth(node.left);
		int rightDepth = depth(node.right);
		diameter = Math.max(diameter, leftDepth + rightDepth + 1);
		return Math.max(leftDepth, rightDepth) + 1;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println(diameterOfBinaryTree(root));
	}

	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}
}