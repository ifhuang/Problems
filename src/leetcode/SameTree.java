package leetcode;

public class SameTree
{
	public boolean isSameTree(TreeNode p, TreeNode q)
	{
		if (p == null && q == null)
			return true;
		if (checkNode(p, q))
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		else
			return false;
	}

	private boolean checkNode(TreeNode p, TreeNode q)
	{
		if (p == null && q == null)
			return true;
		else if (p == null && q != null)
			return false;
		else if (p != null && q == null)
			return false;
		else if (p.val == q.val)
			return true;
		else
			return false;
	}
}
