package leetcode;

import java.util.Arrays;

import leetcode.util.TreeNode;

public class ConstructBinaryTreefromInorderandPostorderTraversal
{
	public TreeNode buildTree(int[] inorder, int[] postorder)
	{
		if (postorder == null || postorder.length == 0)
			return null;
		else if (postorder.length == 1)
		{
			TreeNode node = new TreeNode(postorder[0]);
			return node;
		}
		else
		{
			int length = postorder.length;
			TreeNode root = new TreeNode(postorder[length - 1]);
			int i = 0;
			for (; i < inorder.length; i++)
				if (inorder[i] == postorder[length - 1])
					break;
			root.left = buildTree(Arrays.copyOfRange(inorder, 0, i),
					Arrays.copyOfRange(postorder, 0, i));
			root.right = buildTree(Arrays.copyOfRange(inorder, i + 1, length),
					Arrays.copyOfRange(postorder, i, length - 1));
			return root;
		}
	}
}