package tree;

import java.util.Random;

public class RandomNodeTree {
	
	private static TreeNode root;

	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;
		private int size;

		public TreeNode(int val, int size) {
			this.val = val;
			this.size = size;
		}
	}
	 
	public int getRandomNode() {
		if (root == null)
			throw new NullPointerException();
		Random random = new Random();
		int count = random.nextInt(root.size + 1);
		return getRandomNode(root, count);
	}

	private int getRandomNode(TreeNode curr, int count) {
		if (count == size(curr.left))
			return curr.val;
		if (count < size(curr.left))
			return getRandomNode(curr.left, count);
		return getRandomNode(curr.right, count - size(curr.left) - 1);
	}

	// Return the number of nodes in a given subtree
	private int size(TreeNode n) {
		if (n == null)
			return 0;
		return n.size + 1;
	}

	/*
	 * Insert into binary search tree
	 */
	public void insert(int value) {
		root = insert(root, value);
	}

	private TreeNode insert(TreeNode node, int value) {
		if (node == null) {
			return new TreeNode(value, 0);
		}
		if (value < node.val) {
			node.left = insert(node.left, value);
		} else if (value > node.val) {
			node.right = insert(node.right, value);
		} else {
			node.val = value;
		}
		node.size = sizeOf(node.left) + sizeOf(node.right);
		return node;
	}

	private int sizeOf(TreeNode node) {
		if (node == null)
			return 0;
		return 1 + sizeOf(node.left) + sizeOf(node.right);
	}

	public static void main(String[] args) {
		RandomNodeTree obj = new RandomNodeTree();
		obj.insert(2);
		obj.insert(1);
		obj.insert(3);

		System.out.println(obj.getRandomNode());
	}
}
