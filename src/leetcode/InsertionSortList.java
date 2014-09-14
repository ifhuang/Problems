package leetcode;

import leetcode.util.ListNode;

public class InsertionSortList
{
	public ListNode insertionSortList(ListNode head)
	{
		if (head == null || head.next == null)
			return head;
		ListNode preHead = new ListNode(0);
		preHead.next = head;
		ListNode preMinNode = preHead;
		ListNode minNode = head;
		ListNode p1 = head;
		ListNode p2 = head.next;
		while (p2 != null)
		{
			if (p2.val < minNode.val)
			{
				preMinNode = p1;
				minNode = p2;
			}
			p1 = p1.next;
			p2 = p2.next;
		}
		if (minNode == head)
		{
			head.next = insertionSortList(head.next);
			return head;
		}
		else
		{
			preMinNode.next = minNode.next;
			minNode.next = head;
			minNode.next = insertionSortList(minNode.next);
			return minNode;
		}
	}
}
