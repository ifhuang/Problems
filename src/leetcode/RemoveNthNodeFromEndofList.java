package leetcode;

import leetcode.util.ListNode;

public class RemoveNthNodeFromEndofList
{
	public ListNode removeNthFromEnd(ListNode head, int n)
	{
		if (n < 1 || head == null)
			return head;

		ListNode p = head;
		for (int i = 0; i < n - 1; i++)
		{
			p = p.next;
		}
		ListNode q = head;
		ListNode r = null;
		while (p.next != null)
		{
			p = p.next;
			r = q;
			q = q.next;
		}
		if (r == null)
		{
			return head.next;
		}
		else
		{
			r.next = q.next;
			return head;
		}
	}
}
