package leetcode;

import leetcode.util.ListNode;

public class AddTwoNumbers
{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
		if (l1 == null)
			return l2;
		else if (l2 == null)
			return l1;
		else
		{
			int sum = l1.val + l2.val;
			int now = sum % 10;
			int next = sum / 10;
			ListNode l3 = new ListNode(now);
			ListNode p = l3;
			l1 = l1.next;
			l2 = l2.next;
			while (l1 != null && l2 != null)
			{
				sum = l1.val + l2.val + next;
				now = sum % 10;
				next = sum / 10;
				ListNode q = new ListNode(now);
				p.next = q;
				p = p.next;
				l1 = l1.next;
				l2 = l2.next;
			}
			if (l1 == null && l2 == null)
			{
				if (next == 1)
				{
					ListNode q = new ListNode(next);
					p.next = q;
					p = p.next;
				}
				return l3;
			}
			else if (l1 == null)
			{
				while (l2 != null)
				{
					sum = l2.val + next;
					now = sum % 10;
					next = sum / 10;
					ListNode q = new ListNode(now);
					p.next = q;
					p = p.next;
					l2 = l2.next;
				}
				if (next == 1)
				{
					ListNode q = new ListNode(next);
					p.next = q;
					p = p.next;
				}
				return l3;
			}
			else
			{
				while (l1 != null)
				{
					sum = l1.val + next;
					now = sum % 10;
					next = sum / 10;
					ListNode q = new ListNode(now);
					p.next = q;
					p = p.next;
					l1 = l1.next;
				}
				if (next == 1)
				{
					ListNode q = new ListNode(next);
					p.next = q;
					p = p.next;
				}
				return l3;
			}

		}
	}
}
