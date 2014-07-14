package leetcode;

public class RotateList
{
	public ListNode rotateRight(ListNode head, int n)
	{
		if (head == null || n < 0)
			return null;
		if (n == 0)
			return head;
		ListNode first = head;
		while (n-- > 0)
		{
			if (first == null)
				first = head;
			first = first.next;
		}
		if (first == null)
			return head;
		ListNode second = head;
		while (first.next != null)
		{
			first = first.next;
			second = second.next;
		}
		ListNode newhead = second.next;
		second.next = null;
		first.next = head;
		return newhead;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
}
