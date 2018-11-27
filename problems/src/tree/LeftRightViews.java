package tree;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * 
 problem : Left view/right  of binary tree
 Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 For example:
 Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4]
     1
    / \
  2     2
 / \   / \
3   4 4   3

 */
import java.util.*;

public class LeftRightViews {

	/*
	 * Iterative solution : level order traversal, first element in the level will be in LeftView last
	 * element in the level will be in right view runtime : O(N), Space : O(N);
	 */
	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> leftView = new ArrayList<>();
		List<Integer> rightView = new ArrayList<>();

		if (root == null)
			return rightView;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {  // loop though the queue size
				TreeNode node = queue.poll();
				if (i == 0)                // for left view add the first element
					leftView.add(node.val);
				if (i == size - 1)
					rightView.add(node.val); // for right view add the last element
				
				if (node.left != null)
					queue.add(node.left);
				
				if (node.right != null)
					queue.add(node.right);
			}
		}
		System.out.println("leftView  = " + leftView);
		System.out.println("rightView = " + rightView);
		return rightView;
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
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(5);
		
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(4);
		
		rightSideView(root);
	}
}
