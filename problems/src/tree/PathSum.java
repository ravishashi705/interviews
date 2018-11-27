package tree;

/**
#112 : https://leetcode.com/problems/path-sum/description/

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such 
that adding up all the values along the path equals the given sum.

For example: Given the below binary tree and sum = 22

            5
           / \
          4   8
         /   / \
        11  13  4
       /  \      \
      7    2      1
*/
public class PathSum {

	// Runtime : O(N), Space : O(H) - due to recursive call stack
	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (isLeaf(root) && root.val == sum)
			return true;
		return hasPathSum(root.left, sum - root.val) || 
				hasPathSum(root.right, sum - root.val);
	}

	private static boolean isLeaf(TreeNode node) {
		return (node.left == null && node.right == null);
	}

	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		private TreeNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);

		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);

		int sum = 22;
		boolean hasPathSum = hasPathSum(root, sum);
		System.out.println(hasPathSum);
	}
}
