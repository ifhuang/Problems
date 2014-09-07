package leetcode;

import leetcode.util.ListNode;

public class SwapNodesinPairs
{
	public ListNode swapPairs(ListNode head)
	{
		if (head == null || head.next == null)
			return head;
		ListNode p = head;
		ListNode q = head.next;
		p.next = q.next;
		q.next = p;
		head = q;
		ListNode r = p;
		while (p.next != null && p.next.next != null)
		{
			p = p.next;
			q = p.next;
			p.next = q.next;
			q.next = p;
			r.next = q;
			r = p;
		}
		return head;
	}
}
