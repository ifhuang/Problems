package leetcode;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.util.TreeLinkNode;

public class PopulatingNextRightPointersinEachNodeII
{
	public void connect(TreeLinkNode root)
	{
		if (root == null)
			return;
		Queue<TreeLinkNode> queue = new LinkedList<>();
		root.next = null;
		if (root.left == null && root.right == null)
		{
			return;
		}
		if (root.left != null)
			queue.add(root.left);
		if (root.right != null)
			queue.add(root.right);
		queue.add(null);
		while (!queue.isEmpty())
		{
			TreeLinkNode node = queue.remove();
			if (node != null)
			{
				node.next = queue.peek();
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);

			}
			else
			{
				if (!queue.isEmpty())
					queue.add(null);
				else
					return;
			}
		}
	}
}