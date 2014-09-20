package leetcode;

import leetcode.util.ListNode;

public class ReverseLinkedListII
{
	public ListNode reverseBetween(ListNode head, int m, int n)
	{
		if (head == null || head.next == null || m == n)
			return head;
		int[] num = new int[n - m + 1];
		ListNode p = head;
		int count = 1;
		while (count <= n)
		{
			if (count >= m)
				num[count - m] = p.val;
			count++;
			p = p.next;
		}
		p = head;
		count = 1;
		while (count <= n)
		{
			if (count >= m)
				p.val = num[n - count];
			count++;
			p = p.next;
		}
		return head;
	}
}
