package tree;

public class ConvertSortedListToBST {

	private static ListNode globalHead = null;
	
	public static TreeNode sortedListToBST(ListNode node) {
		if(node == null )
			return null;
		
		globalHead = node;
		
		int start = 0;
		int end = size(node);
		return buildTree(start, end - 1);
	}
	
	private static int size(ListNode node) {
		ListNode curr = node;
		int size = 0;
		while(curr != null) {
			size++;
			curr = curr.next;
		}
		return size;
	}
	
	private static TreeNode buildTree(int start, int end) {
		if (start > end)
			return null;
		int mid = start + (end - start) / 2;

		TreeNode left = buildTree(start, mid - 1);    // left
		TreeNode root = new TreeNode(globalHead.val); // root
		globalHead = globalHead.next; 
		TreeNode right = buildTree(mid + 1, end);     // right
		root.right = right;
		root.left = left;
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

	private static class ListNode {
		private int val;
		private ListNode next;

		public ListNode(int data) {
			this.val = data;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(-10);
		head.next = new ListNode(-3);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(9);
		TreeNode root = sortedListToBST(head);
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
