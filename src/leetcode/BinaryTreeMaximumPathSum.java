package leetcode;

import leetcode.util.TreeNode;

public class BinaryTreeMaximumPathSum
{
	private int max;

	public int maxPathSum(TreeNode root) {
		max = Integer.MIN_VALUE;
		maxNow(root);
		return max;
	}

	private int maxNow(TreeNode x) {
		if (x == null) {
			return 0;
		}
		int left = maxNow(x.left);
		int right = maxNow(x.right);
		int tmp = x.val + left + right;
		max = Math.max(max, tmp);
		return Math.max(0, x.val + Math.max(left, right));
	}
}
