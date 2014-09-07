package leetcode;

import leetcode.util.TreeNode;

public class SumRoottoLeafNumbers
{
	public int sumNumbers(TreeNode root)
	{
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return root.val;
		if (root.left == null)
		{
			root.right.val += root.val * 10;
			return sumNumbers(root.right);
		}
		if (root.right == null)
		{
			root.left.val += root.val * 10;
			return sumNumbers(root.left);
		}
		root.right.val += root.val * 10;
		root.left.val += root.val * 10;
		return sumNumbers(root.right) + sumNumbers(root.left);
	}
}
