package leetcode;

import java.util.HashSet;

import leetcode.util.ListNode;

public class LinkedListCycleII
{
	public ListNode detectCycle(ListNode head)
	{
		if (head == null)
			return null;
		HashSet<ListNode> set = new HashSet<>();
		while (true)
		{
			if (set.contains(head))
				return head;
			else
				set.add(head);
			head = head.next;
			if (head == null)
				return null;
		}
	}
}
