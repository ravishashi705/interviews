package tree;

/**
 *  https://leetcode.com/problems/delete-node-in-a-bst/description/
 *  
 *  9
   / \
  3  20
    /  \
    15  27
      \
      18
      
1. delete (node which doesn't have any children)
2. node with one child (left or right)
3. node with two children (can be root) --> find 15 - which means..minimum on right subtree

 */
public class DeleteNodeBST {

	public static TreeNode deleteNode(TreeNode root, int value) {
		if (root == null)
			return null;
		if (value < root.val) {
			root.left = deleteNode(root.left, value);
		} else if (value > root.val) {
			root.right = deleteNode(root.right, value);
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			root.val = findSuccessor(root.right).val; // replaced min on right child
			root.right = deleteMin(root.right); // delete min on right subtree
		}
		return root;
	}

	private static TreeNode findSuccessor(TreeNode root) {
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

	private static TreeNode deleteMin(TreeNode root) {
		if (root.left == null)
			return root.right;

		root.left = deleteMin(root.left);
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(9);
		root.left = new TreeNode(3);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.left.right = new TreeNode(18);
		root.right.right = new TreeNode(27);
		inorder(root);
		deleteNode(root, 20);
		System.out.println();
		inorder(root);
	}

	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int data) {
			this.val = data;
		}
	}

	private static void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.val + " ");
		inorder(root.right);
	}
}
