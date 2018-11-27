package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 * Given a binary tree, return the in-order traversal of its nodes' values.
Example:
Input: [1,null,2,3]
   1
    \
     2
    /
   3
Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?

 */
public class InOrderTraversal {

	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> inorder = new ArrayList<>();
		
		if (root == null)
			return inorder;
		
		Stack<TreeNode> stack = new Stack<>();
		
		pushNodes(root, stack); // push root and all left parent nodes to stack
		
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			inorder.add(node.val);
			if (node.right != null) { // push right node(if exists) and all left
				pushNodes(node.right, stack);
			}
		}
		return inorder;
	}

	private static void pushNodes(TreeNode node, Stack<TreeNode> stack) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}

	public static List<Integer> inorder(TreeNode root) {
		List<Integer> inorder = new ArrayList<>();
		inorder(root, inorder);
		return inorder;
	}

	private static void inorder(TreeNode node, List<Integer> inorderList) {
		if (node == null)
			return;
		inorder(node.left, inorderList);
		inorderList.add(node.val);
		inorder(node.right, inorderList);
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
		System.out.println(inorder(root));
		System.out.println(inorderTraversal(root));
	}
}
