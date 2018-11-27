package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 * Given a binary tree, return the pre-order traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]

Follow up: Recursive solution is trivial, could you do it iteratively?

 */
public class PreOrderTraversal {

	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> preorder = new ArrayList<>();

		if (root == null)
			return preorder;

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			preorder.add(node.val);

			if (node.right != null)
				stack.push(node.right);

			if (node.left != null)
				stack.push(node.left);
		}
		return preorder;
	}

	public static List<Integer> preorder(TreeNode root) {
		List<Integer> preorder = new ArrayList<>();
		preorder(root, preorder);
		return preorder;
	}

	private static void preorder(TreeNode node, List<Integer> preorderList) {
		if (node == null)
			return;
		preorderList.add(node.val);
		preorder(node.left, preorderList);
		preorder(node.right, preorderList);
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
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(15);
		root.right = new TreeNode(30);
		root.left.left = new TreeNode(10);
		root.left.right = new TreeNode(16);
		root.right.left = new TreeNode(25);
		root.right.right = new TreeNode(35);
		System.out.println(preorder(root));
		System.out.println(preorderTraversal(root));
	}
}
