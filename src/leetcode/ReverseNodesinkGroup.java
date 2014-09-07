package leetcode;

import leetcode.util.ListNode;

public class ReverseNodesinkGroup
{
	public ListNode reverseKGroup(ListNode head, int k)
	{
		if (head == null)
			return head;
		ListNode p = head;
		ListNode[] list = new ListNode[k];
		int i = 0;
		for (; i < k; i++)
		{
			if (p == null)
				break;
			list[i] = p;
			p = p.next;
		}
		if (i < k)
		{
			return head;
		}
		else
		{
			ListNode more = list[k - 1].next;
			for (i = k - 1; i > 0; i--)
			{
				list[i].next = list[i - 1];
			}
			list[0].next = reverseKGroup(more, k);
			return list[k - 1];
		}
	}
}
