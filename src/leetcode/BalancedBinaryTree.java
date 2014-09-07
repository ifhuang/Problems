package leetcode;

import leetcode.util.TreeNode;

public class BalancedBinaryTree
{
	public boolean isBalanced(TreeNode root)
	{
		if (root == null)
			return true;
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		if (Math.abs(left - right) > 1)
			return false;
		if (!isBalanced(root.left))
			return false;
		if (!isBalanced(root.right))
			return false;
		return true;
	}

	private int maxDepth(TreeNode root)
	{
		if (root == null)
			return 0;
		else if (root.left == null)
			return 1 + maxDepth(root.right);
		else if (root.right == null)
			return 1 + maxDepth(root.left);
		else
			return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
}
