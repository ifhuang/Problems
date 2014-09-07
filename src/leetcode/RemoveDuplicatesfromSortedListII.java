package leetcode;

import leetcode.util.ListNode;

public class RemoveDuplicatesfromSortedListII
{
	public ListNode deleteDuplicates(ListNode head)
	{
		if (head == null || head.next == null)
			return head;
		ListNode first = head;
		ListNode second = head.next;
		if (first.val != second.val)
		{
			head.next = deleteDuplicates(head.next);
			return head;
		}
		else
		{
			ListNode p = second.next;
			while (p != null && first.val == p.val)
				p = p.next;
			return deleteDuplicates(p);
		}
	}
}
