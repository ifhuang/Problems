package leetcode;

import java.util.Arrays;

import leetcode.util.TreeNode;

public class ConstructBinaryTreefromPreorderandInorderTraversal
{
	public TreeNode buildTree(int[] preorder, int[] inorder)
	{
		if (preorder == null || preorder.length == 0)
			return null;
		else if (preorder.length == 1)
		{
			TreeNode node = new TreeNode(preorder[0]);
			return node;
		}
		else
		{
			TreeNode root = new TreeNode(preorder[0]);
			int i = 0;
			for (; i < inorder.length; i++)
				if (inorder[i] == preorder[0])
					break;
			root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1),
					Arrays.copyOfRange(inorder, 0, i));
			root.right = buildTree(
					Arrays.copyOfRange(preorder, i + 1, preorder.length),
					Arrays.copyOfRange(inorder, i + 1, inorder.length));
			return root;
		}
	}
}