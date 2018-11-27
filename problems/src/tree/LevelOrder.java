package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

 */
public class LevelOrder {
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> level = new ArrayList<>();
			while (size-- > 0) {
				TreeNode poll = queue.poll();
				level.add(poll.val);
				if (poll.left != null)
					queue.offer(poll.left);
				if (poll.right != null)
					queue.offer(poll.right);
			}
			result.add(level);
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		List<List<Integer>> levelOrder = levelOrder(root);
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
