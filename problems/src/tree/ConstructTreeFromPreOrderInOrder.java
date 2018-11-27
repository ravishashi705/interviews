package tree;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 * Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]

Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 *
 */
public class ConstructTreeFromPreOrderInOrder {

   private static int rootIndex = 0;

   public static TreeNode buildTree(int[] preorder, int[] inorder) {
      return buildTree(preorder, inorder, 0, preorder.length - 1);
  }
  
  private static TreeNode buildTree(int[] pre, int[] in, int start, int end) {
      if(start > end)
         return null;
      
      TreeNode root = new TreeNode(pre[rootIndex]);
      rootIndex++;  // root element for pre-order
      
      int inIndex;
      
      for(inIndex = start; inIndex <= end; inIndex++)
          if(in[inIndex] == root.val)
              break;
      
      root.left = buildTree(pre, in, start, inIndex - 1);
      root.right = buildTree(pre, in, inIndex + 1, end);
      
      return root;
  }
  
  private static void inorder(TreeNode node) {
	  if(node == null)
		  return;
	  inorder(node.left);
	  System.out.println(node.val);
	  inorder(node.right);
  }
   
   public static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}
   
   public static void main(String[] args) {
		int[] pre = {3,9,20,15,7};
		int[] in = {9,3,15,20,7};
   	
		TreeNode root = buildTree(pre, in);
		inorder(root);
   }
}