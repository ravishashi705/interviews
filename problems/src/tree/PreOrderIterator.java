package tree;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class PreOrderIterator implements Iterator<Integer> {

	private TreeNode root;
	private Stack<TreeNode> stack;

	public PreOrderIterator(TreeNode node) {
		this.root = node;
		stack = new Stack<TreeNode>();
	}

	@Override
	public boolean hasNext() {
		return root != null;
	}

	@Override
	public Integer next() {
		if (!hasNext()) {
			throw new NoSuchElementException("Tree is Empty!");
		}
		if (stack.isEmpty())
			stack.push(root); // Note :just push root alone as "root" will be first element to visit in pre-order.

		TreeNode node = stack.pop();

		if (node.right != null) {
			stack.push(node.right); // push right node first
		}
		if (node.left != null) {
			stack.push(node.left); // push right node first
		}
		if (stack.isEmpty()) { // no more elements and mark root is null.
			root = null;
		}
		return node.val;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("This method is not supported");
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(40);
		root.left = new TreeNode(25);
		root.left.left = new TreeNode(10);
		root.left.right = new TreeNode(32);
		root.right = new TreeNode(78);
		root.right.left = new TreeNode(50);
		root.right.right = new TreeNode(93);

		PreOrderIterator preOrderIterator = new PreOrderIterator(root);
		for (Iterator<Integer> itr = preOrderIterator; itr.hasNext();) {
			System.out.print(itr.next() + " ");
		}
	}

	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		private TreeNode(int value) {
			this.val = value;
		}
	}
}
