package tree;

/*
Problem : Given a binary tree, Traverse the tree using postOrder Iterator
			post-order : Left, Right, Root
*/
import java.util.*;

public class PostOrderIterator implements Iterator<Integer> {

	private TreeNode root;
	private Stack<TreeNode> stack;

	public PostOrderIterator(TreeNode node) {
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
			throw new NoSuchElementException("Tree is empty!");
		}
		
		if (stack.isEmpty()) {
			pushLeafNodes(root);   // push node and left if present or right
		}
		
		TreeNode node = stack.pop();
		
		if (!stack.isEmpty()) {
			TreeNode top = stack.peek();
			if (node == top.left) {
				pushLeafNodes(top.right); // find next leaf in right sub-tree
			}
		}
		
		if (stack.isEmpty()) {
			root = null;
		}
		return node.val;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("This method is not supported");
	}

	private void pushLeafNodes(TreeNode node) {
		TreeNode curr = node;
		while (curr != null) {
			stack.push(curr);
			if (curr.left != null) {
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}
	}

	private static void postOrderRecursion(TreeNode root) {
		if (root == null)
			return;
		postOrderRecursion(root.left); // print left children
		postOrderRecursion(root.right); // print right children
		System.out.print(root.val + " "); // print current node
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(40);
		root.left = new TreeNode(25);
		root.left.left = new TreeNode(10);
		root.left.right = new TreeNode(32);
		root.right = new TreeNode(78);
		root.right.left = new TreeNode(50);
		root.right.right = new TreeNode(93);

		PostOrderIterator postOrderIterator = new PostOrderIterator(root);
		for (Iterator<Integer> itr = postOrderIterator; itr.hasNext();) {
			System.out.print(itr.next() + " ");
		}
		System.out.println();
		postOrderRecursion(root);
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
