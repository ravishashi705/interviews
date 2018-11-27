package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/inorder-successor-in-bst/description/
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.

Example 1:

Input: root = [2,1,3], p = 1

  2
 / \
1   3

Output: 2
 */
public class InorderSuccessorBST {
	/*
	 *  Solution :  Iterative solution
	 *  1. base case : if the root is null, return null
	 *  2. if right child is present - get the minimum on right sub tree.
	 *  3. else get the successor(next greater element) - traversing towards root.
	 *  Runtime : O(H), space O(1)
	 */
	public static TreeNode inorderSuccessor(TreeNode root, TreeNode node) {
		if(node == null)
			return null;
		
		if(node.right != null)
			return getMin(node.right);
		
		return getSuccessor(root, node);
		//return getSuccessorV2(root, node);
	}
	
	private static TreeNode getSuccessor(TreeNode root, TreeNode node) {
		TreeNode successor = null;
		while (root != null) {
			if (root.val > node.val) {
				successor = root;
				root = root.left;
			} else if (root.val < node.val) {
				root = root.right;
			} else {
				break;
			}
		}
		return successor;
	}
	
	private static TreeNode getMin(TreeNode node) {
		while(node.left != null) 
			node = node.left;
		return node;
	}
	
	private static TreeNode getSuccessorV2(TreeNode root, TreeNode node) {
		List<TreeNode> path = new Stack<>();
		path = getPath(root, node);
		for(TreeNode n : path) {
			if(n.val > node.val)
				return n;
		}
		return null;
	}
	
	private static List<TreeNode> getPath(TreeNode root, TreeNode node){
		if(root == null || node == null)
			return null;
		
		if(root.equals(node)) {
			List<TreeNode> path = new LinkedList<>();
			path.add(root);
			return path;
		}
		List<TreeNode> leftPath = getPath(root.left, node);
		List<TreeNode> rightPath = getPath(root.right, node);

		if(leftPath == null && rightPath == null)
			return null;
		
		if(leftPath != null) {
			leftPath.add(root);
			return leftPath;
		}
		if(rightPath != null) {
			rightPath.add(root);
			return rightPath;
		}
		return null;
	}
	
	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(6);
		root.right = new TreeNode(13);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(7);
		root.left.left.left = new TreeNode(5);
		
		System.out.println(inorderSuccessor(root, root.left.left.left).val);
	}

}
