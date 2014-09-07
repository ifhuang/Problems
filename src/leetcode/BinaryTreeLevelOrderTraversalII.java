package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.util.TreeNode;

public class BinaryTreeLevelOrderTraversalII
{
	public List<List<Integer>> levelOrderBottom(TreeNode root)
	{
		List<List<Integer>> result = new LinkedList<>();
		List<List<Integer>> levelOrder = levelOrder(root);
		for (int i = levelOrder.size() - 1; i >= 0; i--)
		{
			result.add(levelOrder.get(i));
		}
		return result;
	}

	private List<List<Integer>> levelOrder(TreeNode root)
	{
		List<List<Integer>> result = new LinkedList<>();
		if (root == null)
			return result;
		List<Integer> list = new LinkedList<>();
		list.add(root.val);
		result.add(list);
		Queue<TreeNode> queue = new LinkedList<>();
		if (root.left != null)
			queue.add(root.left);
		if (root.right != null)
			queue.add(root.right);
		if (queue.isEmpty())
			return result;
		queue.add(null);
		list = new LinkedList<>();
		while (!queue.isEmpty())
		{
			TreeNode node = queue.poll();
			if (node == null)
			{
				result.add(list);
				if (queue.isEmpty())
					return result;
				else
				{
					list = new LinkedList<>();
					queue.add(null);
				}
			}
			else
			{
				list.add(node.val);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
		}
		return result;
	}
}
