package tree;

import java.util.Stack;

/**
 *     9
	   / \	
	  3   20
	      / \
	    15  27
	     \
	     18  
 *
 */
public class PathLengthToNode {

	public static int pathLengthFromRoot(TreeNode root, int n1) {
		Stack<TreeNode> stack = path(root, n1);
		if (stack == null)
			return 0;
		return stack.size();
	}
	
	/*
	 *  Recursive solution using stack or List
	 */
	private static Stack<TreeNode> path(TreeNode root, int n1) {
		if (root == null)
			return null;

		if (n1 == root.val) {
			Stack<TreeNode> stack = new Stack<>();
			stack.push(root);
			return stack;
		}
		Stack<TreeNode> left = path(root.left, n1);
		Stack<TreeNode> right = path(root.right, n1);

		if (left != null) {
			left.push(root);
			return left;
		}

		if (right != null) {
			right.push(root);
			return right;
		}
		return null;
	}
	
	/*
	 * Iterative solution
	 */
	public static int pathLengthFromRootIterative(TreeNode root, int n1) {
	    Stack<TreeNode> s = new Stack<>(); // store
	    Stack<Integer> d = new Stack<>();  // store depth
	    s.push(root);
	    d.push(1);
	    
	    while (!s.empty()) {
	        TreeNode node = s.pop();
	        Integer depth = d.pop();
	        
	        if (node == null) 
	            continue;
	        
	        if (node.val == n1) 
	            return depth;
	        
	        s.push(node.left);
	        s.push(node.right);
	        d.push(depth + 1);
	        d.push(depth + 1);
	    }
	    return 0;
	}
	
	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(9);
		root.left = new TreeNode(3);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.left.right = new TreeNode(18);
		root.right.right = new TreeNode(27);
		
		System.out.println(pathLengthFromRoot(root, 9));
		System.out.println(pathLengthFromRootIterative(root, 9));
		
		System.out.println(pathLengthFromRoot(root, 3));
		System.out.println(pathLengthFromRootIterative(root, 3));
		
		System.out.println(pathLengthFromRoot(root, 15));
		System.out.println(pathLengthFromRootIterative(root, 15)); 
		
		System.out.println(pathLengthFromRoot(root, 27));
		System.out.println(pathLengthFromRootIterative(root, 27)); 
	}
}
