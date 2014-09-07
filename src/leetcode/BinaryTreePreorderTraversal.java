package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;

public class BinaryTreePreorderTraversal
{
	public List<Integer> preorderTraversal(TreeNode root)
	{
		List<Integer> list = new ArrayList<>();
		if (root == null)
			return list;
		list.add(root.val);
		List<Integer> left = preorderTraversal(root.left);
		for (Integer integer : left)
		{
			list.add(integer);
		}
		List<Integer> right = preorderTraversal(root.right);
		for (Integer integer : right)
		{
			list.add(integer);
		}
		return list;
	}
}
