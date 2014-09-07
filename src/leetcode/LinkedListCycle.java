package leetcode;

import leetcode.util.ListNode;

public class LinkedListCycle
{
	public boolean hasCycle(ListNode head)
	{
		if (head == null || head.next == null)
			return false;
		ListNode first = head;
		ListNode second = head;
		while (true)
		{
			first = first.next;
			if (first == null)
				return false;
			second = second.next;
			if (second == null)
				return false;
			second = second.next;
			if (second == null)
				return false;
			if (first == second)
				return true;
		}
	}
}
