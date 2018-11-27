package tree;

/**
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

    You may only use constant extra space.
    Recursive approach is fine, implicit stack space does not count as extra space for this problem.
    You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

Example:

Given the following perfect binary tree,

     1
   /  \
  2    3
 / \  / \
4  5  6  7

After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL

 *
 */
public class PopulateTreeNextPointers {

	/*
	 * Iterative solution
	 */
	public void connectIterative(TreeLinkNode root) {
		TreeLinkNode curr = root;
		while (curr != null) {
			populateLowerNextField(curr);
			curr = curr.left;
		}
	}

	private void populateLowerNextField(TreeLinkNode node) {
		TreeLinkNode curr = node;
		while (curr != null && curr.left != null) {
			curr.left.next = curr.right;    // same parent left child next = right child
			if (curr.next != null) {
				curr.right.next = curr.next.left; // current right child next = curr sibling next left child
			}
			curr = curr.next;
		}
	}

	/*
	 * Recursive Solution
	 */
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			root.left.next = root.right;  // curr.left.next = curr.right
		}
		if (root.right != null) {
			if (root.next == null) { // check if parent.next null, then set null
				root.right.next = null;
			} else {
				root.right.next = root.next.left; 
			}
		}
		connect(root.left);
		connect(root.right);
	}

	private static class TreeLinkNode {
		private int val;
		private TreeLinkNode left;
		private TreeLinkNode right;
		private TreeLinkNode next;
	}
}
