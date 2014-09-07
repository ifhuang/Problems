package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;

public class BinaryTreePostorderTraversal
{
	public List<Integer> postorderTraversal(TreeNode root)
	{
		List<Integer> list = new ArrayList<>();
		if (root == null)
			return list;
		List<Integer> left = postorderTraversal(root.left);
		for (Integer integer : left)
		{
			list.add(integer);
		}
		List<Integer> right = postorderTraversal(root.right);
		for (Integer integer : right)
		{
			list.add(integer);
		}
		list.add(root.val);
		return list;
	}
}
