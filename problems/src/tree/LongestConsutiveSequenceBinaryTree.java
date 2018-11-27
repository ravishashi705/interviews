package tree;

/**
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/description/
 * Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

Example 1:

Input:

   1
    \
     3
    / \
   2   4
        \
         5

Output: 3

Explanation: Longest consecutive sequence path is 3-4-5, so return 3.

 */
public class LongestConsutiveSequenceBinaryTree { 
	
	/*
	 * Recursive Solution
	 */
	public int longestConsecutive(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(longestConsecutive(root.left, root.val, 1), longestConsecutive(root.right, root.val, 1));
	}

	private int longestConsecutive(TreeNode node, int previousValue, int length) {
		if (node == null)
			return length;

		if (node.val == previousValue + 1) {  // root.val == previousValue - 1  --> for decreasing sequence
			int left = longestConsecutive(node.left, node.val, length + 1);
			int right = longestConsecutive(node.right, node.val, length + 1);
			return Math.max(left, right);
		} else {
			int left = longestConsecutive(node.left, node.val, 1);  // reset the length to 1
			int right = longestConsecutive(node.right, node.val, 1);
			return Math.max(length, Math.max(left, right));
		}
	}

	public int longestConsecutiveV2(TreeNode root) {
		if (root == null)
			return 0;
		// previousValue -> stores the value of the parent node.
		// Initialize previousValue with one MORE than value of root node so that the
		// path starting at root can be of length at least 1.
		return maxConsecutiveIncreaseSequence(root, root.val - 1, 0);
	}

	private int maxConsecutiveIncreaseSequence(TreeNode node, int previousValue, int previousLength) {
		if (node == null)
			return previousLength;
		int currValue = node.val;
		if (currValue == previousValue + 1) { // the currValue should be greater by 1
			return Math.max(maxConsecutiveIncreaseSequence(node.left, currValue, previousLength + 1),
					maxConsecutiveIncreaseSequence(node.right, currValue, previousLength + 1));
		}
		// reset the count to 1,
		int pathLength = Math.max(maxConsecutiveIncreaseSequence(node.left, currValue, 1),
				maxConsecutiveIncreaseSequence(node.right, currValue, 1));

		return Math.max(previousLength, pathLength);
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
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(5);

		LongestConsutiveSequenceBinaryTree obj = new LongestConsutiveSequenceBinaryTree();
		int consecutiveDec = obj.longestConsecutive(root);
		System.out.println(consecutiveDec);

		int longestDecSequence = obj.longestConsecutiveV2(root);
		System.out.println(longestDecSequence);
	}

}
