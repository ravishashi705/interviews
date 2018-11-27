package tree;

public class SecondLargestNodeBST {
	
	public static int kthLargest(TreeNode root, int k) {
		int[] count = { 0 };
		return largest(root, k, count).val;
	}
	/**
	 *  USe reverse inorder to get Kth largest element
	 *  USe inorder - to get kth smallest element 
	 */
	private static TreeNode largest(TreeNode node, int k, int[] counter) {
		if (node == null)
			return null;

		TreeNode result = largest(node.right, k, counter);  // use node.left for kth smallest element

		if (result == null) {
			counter[0] = counter[0] + 1;
			if (counter[0] == k) {
				result = node;
			}
		}
		if (result == null) {
			result = largest(node.left, k, counter); // // use node.right for kth smallest element
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(9);
		root.left = new TreeNode(3);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.left.right = new TreeNode(18);
		root.right.right = new TreeNode(27);

		System.out.println(kthLargest(root, 1)); // 27
		System.out.println(kthLargest(root, 2)); // 20
		System.out.println(kthLargest(root, 3)); // 18
		System.out.println(kthLargest(root, 4)); // 15
		System.out.println(kthLargest(root, 5)); // 9
		System.out.println(kthLargest(root, 6)); // 3
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
