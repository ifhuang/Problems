package leetcode;

import leetcode.util.ListNode;
import leetcode.util.TreeNode;

public class ConvertSortedListtoBinarySearchTree
{
	public TreeNode sortedListToBST(ListNode head)
	{
		if (head == null)
			return null;
		else if (head.next == null)
			return new TreeNode(head.val);
		else
		{
			int count = 1;
			ListNode p = head;
			while (p.next != null)
			{
				count++;
				p = p.next;
			}
			int mid = count / 2;
			ListNode pre = head;
			ListNode now = head.next;
			while (mid > 1)
			{
				pre = pre.next;
				now = now.next;
				mid--;
			}
			TreeNode treeNode = new TreeNode(now.val);
			pre.next = null;
			treeNode.left = sortedListToBST(head);
			treeNode.right = sortedListToBST(now.next);
			return treeNode;
		}
	}
}
