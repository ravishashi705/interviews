package tree;

/**
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii/description/
 *  Given a binary tree, you need to find the length of Longest Consecutive Path in Binary Tree.

Especially, this path can be either increasing or decreasing. For example, [1,2,3,4] and [4,3,2,1] are both considered valid, but the path [1,2,4,3] is not valid. On the other hand, the path can be in the child-Parent-child order, where not necessarily be parent-child order.

Example 1:

Input:
        1
       / \
      2   3
      
Output: 2

Explanation: The longest consecutive path is [1, 2] or [2, 1].
 *
 */
public class LongestConsecutiveSequenceII {
	
	private int maxval = 0;

	public int longestConsecutive(TreeNode root) {
		longestPath(root);
		return maxval;
	}

	public int[] longestPath(TreeNode root) {

		if (root == null)
			return new int[] { 0, 0 };

		int incSeq = 1;
		int decSeq = 1;

		if (root.left != null) {   // check on left subtree
			int[] left = longestPath(root.left);

			if (root.val == root.left.val + 1) // check of decreasing sequence
				decSeq = left[1] + 1;

			else if (root.val == root.left.val - 1) //check of decreasing sequence
				incSeq = left[0] + 1;
		}

		if (root.right != null) {  // check on right subtree
			int[] right = longestPath(root.right);

			if (root.val == root.right.val + 1)
				decSeq = Math.max(decSeq, right[1] + 1);

			else if (root.val == root.right.val - 1)
				incSeq = Math.max(incSeq, right[0] + 1);
		}

		maxval = Math.max(maxval, decSeq + incSeq - 1);

		return new int[] { incSeq, decSeq };
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

		LongestConsecutiveSequenceII obj = new LongestConsecutiveSequenceII();
		System.out.println(obj.longestConsecutive(root));
	}
}
