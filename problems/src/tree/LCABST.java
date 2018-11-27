package tree;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5

Example 1:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

 */
public class LCABST {
	// Recursive solution, Runtime : O(log N), Space : O(H), recursive stack.
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		if (root.equals(p) || root.equals(q))
			return root;
		if (root.val > Math.max(p.val, q.val)) {
			return lowestCommonAncestor(root.left, p, q);
		} else if (root.val < Math.min(p.val, q.val)) {
			return lowestCommonAncestor(root.right, p, q);
		} else {
			return root;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		System.out.println(lowestCommonAncestor(root, root.left, root.right).val); // 6
	}
	
	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode(int data) {
			this.val = data;
		}
	}

}
