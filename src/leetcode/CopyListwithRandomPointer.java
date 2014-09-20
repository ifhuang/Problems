package leetcode;

import leetcode.util.RandomListNode;

public class CopyListwithRandomPointer
{
	public RandomListNode copyRandomList(RandomListNode head)
	{
		if (head == null)
			return null;
		RandomListNode p = head;
		while (p != null)
		{
			RandomListNode q = new RandomListNode(p.label);
			q.next = p.next;
			p.next = q;
			p = q.next;
		}
		p = head;
		while (p != null)
		{
			if (p.random == null)
				p.next.random = null;
			else
				p.next.random = p.random.next;
			p = p.next.next;
		}
		RandomListNode newHead = head.next;
		p = head;
		RandomListNode q = newHead;
		if(q.next==null)
		{
			p.next = q.next;
		}
		else
		{
			while (q.next != null)
			{
				p.next = q.next;
				q.next = p.next.next;
				p = p.next;
				q = q.next;
			}
			p.next = q.next;
		}
		return newHead;
	}

}
