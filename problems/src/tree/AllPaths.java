package tree;

import java.util.ArrayList;
import java.util.List;
/**
 * https://leetcode.com/problems/binary-tree-paths/description/
 * 
 * Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 *
 */
public class AllPaths {
	
	/*
	 * Use recursion,  Runtime : O(N); Space : O(1)
	 */
	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new ArrayList<>();
		if(root == null)
			return paths;
		
		allPaths(root, "", paths);
		return paths;
	}
	
	private static void allPaths(TreeNode node, String path, List<String> paths) {
		if(node == null)
			return;
		
		if(isLeafNode(node)) {
			path += node.val;  // add the leaf node to path
			paths.add(path); 
			return;
		}
		path += node.val + "->" ;   // continue if its not a leaf node
		allPaths(node.left, path, paths);
		allPaths(node.right, path, paths);
	}
	
	private static boolean isLeafNode(TreeNode node) {
		return node.left == null && node.right == null;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		System.out.println(binaryTreePaths(root));
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
