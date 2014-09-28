package leetcode;

import leetcode.util.TreeNode;

public class ValidateBinarySearchTree
{
	public boolean isValidBST(TreeNode root)
	{
		if (root == null)
			return true;
		else if (root.left == null && root.right == null)
			return true;
		else if (root.left == null && root.right != null)
		{
			TreeNode node = root.right;
			while (node.left != null)
				node = node.left;
			return root.val < node.val && isValidBST(root.right);
		}
		else if (root.left != null && root.right == null)
		{
			TreeNode node = root.left;
			while (node.right != null)
				node = node.right;
			return node.val < root.val && isValidBST(root.left);
		}
		else
		{
			TreeNode nodeR = root.right;
			while (nodeR.left != null)
				nodeR = nodeR.left;
			TreeNode nodeL = root.left;
			while (nodeL.right != null)
				nodeL = nodeL.right;
			return root.val < nodeR.val && isValidBST(root.right)
					&& nodeL.val < root.val && isValidBST(root.left);
		}
	}
}
