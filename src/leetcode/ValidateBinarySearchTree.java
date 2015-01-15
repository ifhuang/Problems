package leetcode;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/validate-binary-search-tree/
public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		boolean ans = true;
		if (root != null) {
			if (root.left != null) {
				TreeNode lmax = root.left;
				while (lmax.right != null)
					lmax = lmax.right;
				ans = ans && root.val > lmax.val && isValidBST(root.left);
			}
			if (root.right != null) {
				TreeNode rmin = root.right;
				while (rmin.left != null)
					rmin = rmin.left;
				ans = ans && root.val < rmin.val && isValidBST(root.right);
			}
		}
		return ans;
	}
}
