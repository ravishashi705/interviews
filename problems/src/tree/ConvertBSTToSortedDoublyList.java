package tree;

/**
 * https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/description/
 *  
 *  Convert a BST to a sorted circular doubly-linked list in-place. Think of the left and right pointers 
 *  as synonymous to the previous and next pointers in a doubly-linked list.

Let's take the following BST as an example, it may help you understand the problem better:
 
						4
					  / \
                2   5
               / \ 
              1   3
 
We want to transform this BST into a circular doubly linked list. Each node in a doubly linked list has a 
predecessor and successor. For a circular doubly linked list, the predecessor of the first element is the 
last element, and the successor of the last element is the first element.

The figure below shows the circular doubly linked list for the BST above. The "head" symbol means the node 
it points to is the smallest element of the linked list.
 
Specifically, we want to do the transformation in place. After the transformation, the left pointer of the 
tree node should point to its predecessor, and the right pointer should point to its successor. 
We should return the pointer to the first element of the linked list.

The figure below shows the transformed BST. The solid line indicates the successor relationship, 
while the dashed line means the predecessor relationship.
 *
 */

public class ConvertBSTToSortedDoublyList {

	private Node prev = null;

	public Node treeToDoublyList(Node root) {
		if (root == null)
			return null;

		Node dummy = new Node(0);  // Temp node to hold.
		prev = dummy;
		inorder(root);
		prev.right = dummy.right;
		dummy.right.left = prev;
		return dummy.right;      // or return prev.right
	}

	private void inorder(Node root) {
		if (root == null)
			return;

		inorder(root.left);

		prev.right = root;
		root.left = prev;
		prev = prev.right;  // or prev = root

		inorder(root.right);
	}

	public static void main(String[] args) {
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		
		ConvertBSTToSortedDoublyList obj = new ConvertBSTToSortedDoublyList();
		
		Node head = obj.treeToDoublyList(root);
		
		print(head);
	}

	private static void print(Node node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.right;
		}
	}

	private static class Node {
		private int val;
		private Node left;
		private Node right;

		public Node(int data) {
			this.val = data;
		}
	}
}
