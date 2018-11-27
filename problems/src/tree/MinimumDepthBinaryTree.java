package tree;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 * 
 Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its minimum depth = 2.

 */
import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthBinaryTree {

	public static int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		int minDepth = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				TreeNode node = queue.poll();
				// if this is a leaf node, then return its depth
				if (node.left == null && node.right == null)
					return minDepth;
				
				if (node.left != null)
					queue.offer(node.left);
				
				if (node.right != null)
					queue.offer(node.right);
			}
			minDepth++;
		}
		return minDepth;
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
		System.out.println(minDepth(root));
	}

}
