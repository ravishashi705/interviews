package tree;

import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-search-tree-iterator/description/
 *  Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree. 
 */
public class BSTIterator {
	
	private TreeNode root;
	private Stack<TreeNode> stack;
	
	public BSTIterator(TreeNode node) {
		this.root = node;
		this.stack = new Stack<>();
	}
	
	public boolean hasNext() {
		return root != null;
	}
	
	public int next() {
		
		if(stack.isEmpty()) {   // check if stack is empty, then push root and left children
			pushNodes(root, stack);
		}
		TreeNode temp = stack.pop();
		
		if(temp.right != null) {
			pushNodes(temp.right, stack);
		}
		
		if(stack.isEmpty())  // is stack is empty, make the root null
			root = null;
		
		return temp.val;
	}
	
	private static void pushNodes(TreeNode node, Stack<TreeNode> stack) {
		if(node == null)
			return;
		TreeNode curr = node;
		while(curr != null) {
			stack.push(curr);
			curr = curr.left;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		
    	BSTIterator iterator = new BSTIterator(root);
    	while(iterator.hasNext()){
    		System.out.print(iterator.next() + " ");
    	}
    	System.out.println();
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
