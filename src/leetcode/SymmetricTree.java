package leetcode;

import leetcode.util.TreeNode;

public class SymmetricTree
{
	public boolean isSymmetric(TreeNode root)
	{
		if (root == null)
			return true;
		if (root.left == null && root.right == null)
			return true;
		if (root.left == null)
			return false;
		if (root.right == null)
			return false;
		if (root.left.val != root.right.val)
			return false;
		TreeNode root1 = new TreeNode(0);
		root1.left = root.left.left;
		root1.right = root.right.right;
		if (!isSymmetric(root1))
			return false;
		TreeNode root2 = new TreeNode(0);
		root2.left = root.left.right;
		root2.right = root.right.left;
		if (!isSymmetric(root2))
			return false;
		return true;
	}

	public static void main(String[] args)
	{
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(2);
		SymmetricTree s = new SymmetricTree();
		System.out.println(s.isSymmetric(node));
	}
}
