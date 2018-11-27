package tree;

import java.util.Arrays;

public class ConstructBSTFromPreOrder {

	private static TreeNode constructBSTFromPreOrder(int[] preorder) {
		if (preorder == null)
			return null;
		return buildTree(preorder, 0, preorder.length - 1);
	}

	private static TreeNode buildTree(int[] preorder, int start, int end) {
		if (start > end)
			return null;

		TreeNode root = new TreeNode(preorder[start]); // first element is ROOT.

		int index;
		for (index = start + 1; index <= end; index++) // start + 1 because, root element is excluded
			if (preorder[index] > root.val) // find index where right subtree starts
				break;

		root.left = buildTree(preorder, start + 1, index - 1); // left subtree starts after root and till the index
		root.right = buildTree(preorder, index, end); // right sub tree starts from index to end
		return root;
	}

	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		private TreeNode(int value) {
			this.val = value;
		}
	}

	private static void preOrder(TreeNode TreeNode) {
		if (TreeNode == null)
			return;
		System.out.print(TreeNode.val + " ");
		preOrder(TreeNode.left);
		preOrder(TreeNode.right);
	}

	public static void main(String[] args) {
		int[] preorder = { 20, 15, 10, 16, 30, 25, 40 };
		System.out.println(Arrays.toString(preorder));
		TreeNode root = constructBSTFromPreOrder(preorder);
		preOrder(root);
	}

}
