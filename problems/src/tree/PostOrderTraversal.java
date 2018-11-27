package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 * Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]

Follow up: Recursive solution is trivial, could you do it iteratively?

 */
public class PostOrderTraversal {

	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> postorder = new ArrayList<>();
		if (root == null)
			return postorder;

		Stack<TreeNode> stack = new Stack<>();
		pushNodes(root, stack); 

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			postorder.add(node.val);

			if (!stack.isEmpty()) {
				TreeNode top = stack.peek();
				if (node == top.left) {
					pushNodes(top.right, stack);
				}
			}
		}
		return postorder;
	}

	private static void pushNodes(TreeNode node, Stack<TreeNode> stack) {
		while (node != null) {
			stack.push(node);
			if(node.left != null) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
	}

	public static List<Integer> postorder(TreeNode root) {
		List<Integer> inorder = new ArrayList<>();
		postorder(root, inorder);
		return inorder;
	}

	private static void postorder(TreeNode node, List<Integer> postorderList) {
		if (node == null)
			return;
		postorder(node.left, postorderList);
		postorder(node.right, postorderList);
		postorderList.add(node.val);
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
		System.out.println(postorder(root));
		System.out.println(postorderTraversal(root));
	}

}
