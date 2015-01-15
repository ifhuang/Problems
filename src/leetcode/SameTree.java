package leetcode;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/symmetric-tree/
public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		else if (p == null || q == null)
			return false;
		else
			return p.val == q.val && isSameTree(p.left, q.left)
					&& isSameTree(p.right, q.right);
	}
}
