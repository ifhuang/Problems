package leetcode;

import leetcode.util.ListNode;

public class RemoveDuplicatesfromSortedList
{
	public ListNode deleteDuplicates(ListNode head)
	{
		if (head == null)
			return head;
		int val = head.val;
		ListNode p = head.next;
		while (p != null)
		{
			if (p.val != val)
				break;
			p = p.next;
		}
		head.next = deleteDuplicates(p);
		return head;
	}
}
