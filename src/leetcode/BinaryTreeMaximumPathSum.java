package leetcode;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/binary-tree-maximum-path-sum/
public class BinaryTreeMaximumPathSum {
	private int ans;
	public int maxPathSum(TreeNode root) {
		ans = Integer.MIN_VALUE;
		helper(root);
		return ans;
	}
	private int helper(TreeNode root) {
		if (root == null)
			return 0;
		int left = Math.max(0, helper(root.left));
		int right = Math.max(0, helper(root.right));
		ans = Math.max(ans, root.val + left + right);
		return root.val + Math.max(left, right);
	}
}
