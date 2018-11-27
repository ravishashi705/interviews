package tree;

import java.util.Stack;
/**
 *  # 114 : https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 *  
 * Flatten Binary Tree to Linked List
	Given a binary tree, flatten it to a linked list in-place.
	For example, given the following tree:
    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:
1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 */
public class FlattenBinaryTreeToLinkedList {
	/**
	 * Solution : Follow the Pre-order Traversal - Iterative
	 * node.right = stack.peek();
	 * node.left = null;
	 */
	public static void flatten(TreeNode root) {
		 if(root == null)
          return;

      Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if(node.right != null)
				stack.push(node.right);
			if(node.left != null)
				stack.push(node.left);
			
          if(!stack.isEmpty())
              node.right = stack.peek();  // assign the right pointer
			node.left = null;  // make sure to null the left pointer
		}
	}

	public static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int x) {
			val = x;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(6);
		flatten(root);
	}
}
