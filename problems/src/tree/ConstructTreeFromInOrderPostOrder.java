package tree;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

  inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]

Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

 */
public class ConstructTreeFromInOrderPostOrder{
	
	private static int rootIndex = 0;
	
   public  static TreeNode buildTree(int[] inorder, int[] postorder) {
       rootIndex = postorder.length - 1;
       return buildTree(inorder, postorder, 0, postorder.length - 1);
   }
   
	private static TreeNode buildTree(int[] inorder, int[] postorder, int start, int end) {
		if(start > end)
			return null;
       
       TreeNode root = new TreeNode(postorder[rootIndex]);
		rootIndex--;

       if(start == end)
			return root;
		
		int idx = 0;
		for(int i = start; i <= end; i++) {
			if(inorder[i] == root.val) {
				idx = i;
				break;
			}
		}
		root.right = buildTree(inorder, postorder, idx + 1, end);
		root.left = buildTree(inorder, postorder, start, idx - 1);
		return root;
	}
	
	private static void postorder(TreeNode node) {
		if(node == null)
			return;
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.val + " ");
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
		int[] inorder = {9,3,15,20,7};
		int[] postorder = {9, 15, 7, 20, 3 };
		rootIndex = postorder.length - 1;
		TreeNode root = buildTree(inorder, postorder);
		postorder(root);
	}

}
