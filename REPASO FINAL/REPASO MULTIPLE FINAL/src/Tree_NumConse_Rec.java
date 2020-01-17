//Given a binary tree, find the length of the longest path where each node in the path has the same value.
//This path may or may not pass through the root.
public class Tree_NumConse_Rec{
	class Solution {
		int ans;
		public int longestUnivaluePath(TreeNode root) {
			ans = 0;
			arrowLength(root);
			return ans;
		}
		public int arrowLength(TreeNode node) {
			if (node == null) return 0;
			int left = arrowLength(node.left);
					int right = arrowLength(node.right);
			int arrowLeft = 0, arrowRight = 0;
			if (node.left != null && node.left.val == node.val) {
				arrowLeft += left + 1;
			}
			if (node.right != null && node.right.val == node.val) {
				arrowRight += right + 1;
			}
			ans = Math.max(ans, arrowLeft + arrowRight);
			return Math.max(arrowLeft, arrowRight);
		}
	}
	
}
