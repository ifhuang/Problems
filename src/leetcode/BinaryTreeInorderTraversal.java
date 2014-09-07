package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;

public class BinaryTreeInorderTraversal
{
	public List<Integer> inorderTraversal(TreeNode root)
	{
		List<Integer> list = new ArrayList<>();
		if (root == null)
			return list;
		List<Integer> left = inorderTraversal(root.left);
		for (Integer integer : left)
		{
			list.add(integer);
		}
		list.add(root.val);
		List<Integer> right = inorderTraversal(root.right);
		for (Integer integer : right)
		{
			list.add(integer);
		}
		return list;
	}
}
