package leetcode;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
		return helper(num, 0, num.length - 1);
	}
	private TreeNode helper(int[] num, int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) >>> 1;
		TreeNode root = new TreeNode(num[mid]);
		root.left = helper(num, start, mid - 1);
		root.right = helper(num, mid + 1, end);
		return root;
	}
}
