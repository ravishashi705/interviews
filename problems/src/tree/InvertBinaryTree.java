package tree;

/**
 * Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9

Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1

*/
public class InvertBinaryTree {
	
	public TreeNode invertTree(TreeNode root) {
	    if (root == null) 
	        return null;
	    TreeNode left = invertTree(root.left);
	    TreeNode right = invertTree(root.right);
	    root.left = right;
	    root.right = left;
	    return root;
	 }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		
		InvertBinaryTree obj = new InvertBinaryTree();
		TreeNode node = obj.invertTree(root);
		inorder(node);
	}
	
	private static void inorder(TreeNode node) {
		if(node == null)
			return;
		inorder(node.left);
		System.out.print(node.val + " ");
		inorder(node.right);
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
