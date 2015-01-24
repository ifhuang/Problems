package leetcode;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class FlattenBinaryTreetoLinkedList {
	public void flatten(TreeNode root) {
		if (root == null)
			return;
		if (root.left != null) {
			if (root.right != null) {
				TreeNode p = root.left;
				while (p.right != null)
					p = p.right;
				p.right = root.right;
			}
			root.right = root.left;
			root.left = null;
		}
		if (root.right != null)
			flatten(root.right);
	}
}
