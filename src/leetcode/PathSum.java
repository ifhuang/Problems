package leetcode;

import java.util.HashSet;
import java.util.Set;

import leetcode.util.TreeNode;

public class PathSum
{
	public boolean hasPathSum(TreeNode root, int sum)
	{
		Set<Integer> set = new HashSet<>();
		pathSums(set, root);
		if (set.contains(sum))
			return true;
		else
			return false;
	}

	private void pathSums(Set<Integer> set, TreeNode root)
	{
		if (root == null)
			return;
		if (root.left == null && root.right == null)
			set.add(root.val);
		if (root.left != null)
		{
			root.left.val += root.val;
			pathSums(set, root.left);
		}
		if (root.right != null)
		{
			root.right.val += root.val;
			pathSums(set, root.right);
		}
	}
}
