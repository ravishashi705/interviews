package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */
public class ZigZagLevelOrder {
	/*
	 * DFS traversal - pre-order
	 */
	public static List<List<Integer>> zigzagLevelOrderDFS(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		preorder(root, result, 0);
		return result;
	}

	private static void preorder(TreeNode node, List<List<Integer>> result, int level) {
		if (node == null)
			return;

		if (result.size() <= level) {
			List<Integer> list = new ArrayList<Integer>();
			result.add(list);
		}

		List<Integer> list = result.get(level);
		
		if (level % 2 == 0)
			list.add(node.val);  // add to start
		else
			list.add(0, node.val); // add to the end

		preorder(node.left, result, level + 1);
		preorder(node.right, result, level + 1);
	}
	
	/*
	 * BFS traversal
	 */
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();

		Stack<TreeNode> evenStack = new Stack<TreeNode>();
		Stack<TreeNode> oddStack = new Stack<TreeNode>();
		evenStack.push(root); // root is at level = 0, evenStack

		while (!evenStack.isEmpty() || !oddStack.isEmpty()) {
			List<Integer> even = new ArrayList<>();
			List<Integer> odd = new ArrayList<>();

			while (!evenStack.isEmpty()) {
				TreeNode temp = evenStack.pop();
				even.add(temp.val);
				if (temp.left != null) {
					oddStack.push(temp.left);
				}
				if (temp.right != null) {
					oddStack.push(temp.right);
				}
			}

			while (!oddStack.isEmpty()) {
				TreeNode temp = oddStack.pop();
				odd.add(temp.val);
				if (temp.right != null) {
					evenStack.push(temp.right);
				}
				if (temp.left != null) {
					evenStack.push(temp.left);
				}
			}
			if(even.size() > 0)
				result.add(even);
			
			if(odd.size() > 0)
				result.add(odd);
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		List<List<Integer>> levelOrder = zigzagLevelOrder(root);
		for(List<Integer> level : levelOrder) {
			System.out.println(level);
		}
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
