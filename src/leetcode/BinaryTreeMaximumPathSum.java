package leetcode;

import leetcode.util.TreeNode;

public class BinaryTreeMaximumPathSum
{
	private int max;

	public int maxPathSum(TreeNode root)
	{
		if (root == null)
			return 0;
		max = root.val;
		maxNow(root);
		return max;
	}

	private int maxNow(TreeNode root)
	{
		int left = 0;
		int right = 0;
		if (root.left != null)
			left = maxNow(root.left);
		if (root.right != null)
			right = maxNow(root.right);
		left = Math.max(0, left);
		right = Math.max(0, right);
		int tmp = root.val + left + right;
		max = Math.max(max, tmp);
		return root.val + Math.max(left, right);
	}
}