package tree;
/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 * 
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

 */
public class ConstructBSTFromSortedArray {
	
	public static TreeNode sortedArrayToBST(int[] sortedArr) {
		if(sortedArr == null || sortedArr.length == 0)
			return null;
		
		int start = 0;
		int end = sortedArr.length - 1;
		return buildTree(sortedArr, start, end);
	}
	
	private static TreeNode buildTree(int[] arr, int start, int end) {
		if(start > end)
			return null;
		int mid = start + (end - start)/2;
		TreeNode root = new TreeNode(arr[mid]);
		root.left = buildTree(arr, start, mid - 1);
		root.right = buildTree(arr, mid + 1, end);
		return root;
	}

	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int data) {
			this.val = data;
		}
	}

	public static void main(String[] args) {
		int[] sortedArray = { -10, -3, 0, 5, 9 };
		TreeNode root = sortedArrayToBST(sortedArray);
		inorder(root);
	}
	
	private static void inorder(TreeNode root) {
		if(root == null)
			return;
		inorder(root.left);
		System.out.print(root.val + " ");
		inorder(root.right);
	}

}
