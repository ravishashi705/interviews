package tree;
/**
 * This problem was asked by Microsoft.
	Suppose an arithmetic expression is given as a binary tree. Each leaf is an integer 
	and each internal node is one of '+', '−', '∗', or '/'.

	Given the root to such a tree, write a function to evaluate it.
	For example, given the following tree:
    *
   / \
  +    +
 / \  / \
3  2  4  5

You should return 45, as it is (3 + 2) * (4 + 5).
 *
 */
public class EvaluateExpressionTree {
	/*
	 * Recursive solution : Runtime O(N), space : O(H) - for call stack
	 * 1. base-case if root == null, return 0;
	 * 2. if leaf node, return integer value;
	 * 3. recurse on left = recurse(root.left)
	 * 4. recurse on right = recurse(root.right)
	 * 5. apply operator and return value
	 */
	private int evaluate(TreeNode node) {
		if (node == null)
			return 0;

		if (node.left == null && node.right == null) // leaf node
			return node.val - '0'; // node value

		int leftVal = evaluate(node.left); // left node value
		int rightVal = evaluate(node.right); // right node value

		// apply operator
		return applyOperator(leftVal, node.val, rightVal);
	}

	private int applyOperator(int leftVal, char op, int rightVal) {
		if (op == '+')
			return leftVal + rightVal;
		if (op == '-') 
			return leftVal - rightVal;

		if (op == '*')
			return leftVal * rightVal;
		else
			return leftVal / rightVal;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode('*');
		root.left = new TreeNode('+');
		root.left.left = new TreeNode('3');
		root.left.right = new TreeNode('2');
		
		root.right = new TreeNode('+');
		root.right.left = new TreeNode('4');
		root.right.right = new TreeNode('5');
		
		EvaluateExpressionTree obj = new  EvaluateExpressionTree();
		System.out.println(obj.evaluate(root));
	}
	
	private static class TreeNode {
		private char val;
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode(char data) {
			this.val = data;
		}
	}
}
