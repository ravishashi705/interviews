package tree;

/**
 * https://leetcode.com/problems/count-univalue-subtrees/description/
 *  
 *  Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

Example :

Input:  root = [5,1,5,5,5,null,5]

              5
             / \
            1   5
           / \   \
          5   5   5

Output: 4
 *
 */
public class UnivalTree {

	private int count = 0;

	// Post order
	public int countUnivalSubtrees(TreeNode root) {
		if (root == null)
			return 0;
		countUnivalSubtrees(root.left);
		countUnivalSubtrees(root.right);
		if (isUniVal(root))
			count++;
		return count;
	}

	// pre-order (left, root, right)
	public boolean isUniVal(TreeNode root) {
		if (root == null)
			return true;
		
		if (root.left != null)
			if ((root.left.val != root.val))
				return false;
		
		if (root.right != null)
			if ((root.right.val != root.val))
				return false;
		
		return isUniVal(root.left) && isUniVal(root.right);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(5);

		UnivalTree obj = new UnivalTree();
		System.out.println(obj.countUnivalSubtrees(root));
	}

	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		private TreeNode(int val) {
			this.val = val;
		}
	}
}
