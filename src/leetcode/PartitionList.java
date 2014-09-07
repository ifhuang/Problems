package leetcode;

import leetcode.util.ListNode;

public class PartitionList
{
	public ListNode partition(ListNode head, int x)
	{
		if (head == null || head.next == null)
			return head;
		ListNode first = new ListNode(0);
		first.next = head;
		ListNode insertPre = first;
		while (insertPre.next != null && insertPre.next.val < x)
			insertPre = insertPre.next;
		if (insertPre.next == null)
			return first.next;
		ListNode p = insertPre;
		while (p.next != null)
		{
			ListNode pre = p;
			p = p.next;
			if (p.val < x)
			{
				pre.next = p.next;
				p.next = insertPre.next;
				insertPre.next = p;
				insertPre = insertPre.next;
				p = pre;
			}
		}
		return first.next;
	}

	public static void main(String[] args)
	{
	}
}
