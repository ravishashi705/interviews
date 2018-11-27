package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *  https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 *  
 * You may serialize the following tree:
 * 
 *  1
   / \
  2   3
     / \
    4   5
 * 
 * as "[1,2,3,null,null,4,5]"
 *
 */
public class SerializeDeserializeBinaryTree {

	/*
	 *  Encodes a tree to a single string.
	 */
	public static String serialize(TreeNode root) {
		if (root == null)
			return "";

		StringBuilder sb = new StringBuilder();  // to store the serialized string
		serialize(root, sb);
		return sb.toString();
	}

	private static void serialize(TreeNode node, StringBuilder sb) {
		if (node == null) {
			sb.append("null,");
			return;
		}
		sb.append(node.val + ",");  // pre-order traversal of the tree
		serialize(node.left, sb);
		serialize(node.right, sb);
	}
	
	/**
	 *  Decodes your encoded data to tree.
	 */
	public static TreeNode deserialize(String tree) {
		if (tree == null || tree.length() == 0)
			return null;
		List<String> nodes = new LinkedList<>(Arrays.asList(tree.split(",")));
		return deserialize(nodes);
	}

	/**
	 * follow the same pre-order(DFS) for deserialize 
	 */
	public static TreeNode deserialize(List<String> nodes) {
		if (nodes.get(0).equals("null")) {
			nodes.remove(0);
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(nodes.get(0)));
		nodes.remove(0);
		root.left = deserialize(nodes);
		root.right = deserialize(nodes);
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);

		String serializedTree = serialize(root);
		System.out.println(serializedTree);
		TreeNode result = deserialize(serializedTree);
		inorder(result);
	}

	private static void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.val + " ");
		inorder(root.right);
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
