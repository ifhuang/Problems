package leetcode;

import java.util.LinkedList;
import java.util.List;

import leetcode.util.TreeNode;

public class PathSumII
{
	public List<List<Integer>> pathSum(TreeNode root, int sum)
	{
		List<List<Integer>> result = new LinkedList<>();
		if (root == null)
			return result;
		else if (root.left == null && root.right == null)
		{
			if (root.val == sum)
			{
				List<Integer> list = new LinkedList<>();
				list.add(root.val);
				result.add(list);
			}
			return result;
		}
		else
		{
			sum -= root.val;
			if (root.left != null)
			{
				List<List<Integer>> left = pathSum(root.left, sum);
				for (List<Integer> list : left)
				{
					list.add(0, root.val);
					result.add(list);
				}
			}
			if (root.right != null)
			{
				List<List<Integer>> left = pathSum(root.right, sum);
				for (List<Integer> list : left)
				{
					list.add(0, root.val);
					result.add(list);
				}
			}
			return result;
		}
	}

	public static void main(String[] args)
	{
		PathSumII solution = new PathSumII();
		TreeNode root = new TreeNode(-2);
		root.right = new TreeNode(-3);
		System.out.println(solution.pathSum(root, -5));
	}
}