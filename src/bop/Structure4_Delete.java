package bop;

import leetcode.util.ListNode;

public class Structure4_Delete
{
	public void delete(ListNode here)
	{
		here.val = here.next.val;
		here.next = here.next.next;
	}

	public static void main(String[] args)
	{
		Structure4_Delete s = new Structure4_Delete();
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		ListNode.print(head);
		s.delete(head.next);
		ListNode.print(head);
	}
}
