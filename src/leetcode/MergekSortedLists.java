package leetcode;

import java.util.ArrayList;

import leetcode.util.ListNode;

public class MergekSortedLists
{
	public ListNode mergeKLists(ArrayList<ListNode> lists)
	{
		if (lists == null)
			return null;
		int i = 0;
		for (; i < lists.size(); i++)
		{
			ListNode listNode = lists.get(i);
			if (listNode != null)
				break;
		}
		if (i == lists.size())
		{
			return null;
		}

		ListNode head = null;
		ListNode minNode = null;
		int index = 0;
		int min = Integer.MAX_VALUE;
		for (i = 0; i < lists.size(); i++)
		{
			ListNode listNode = lists.get(i);
			if (listNode == null)
			{
				continue;
			}
			else
			{
				if (listNode.val < min)
				{
					min = listNode.val;
					minNode = listNode;
					index = i;
				}
			}
		}

		head = new ListNode(minNode.val);
		lists.set(index, minNode.next);
		head.next = mergeKLists(lists);

		return head;
	}
}
