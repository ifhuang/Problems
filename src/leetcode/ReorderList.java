package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.ListNode;

public class ReorderList
{
	public void reorderList(ListNode head)
	{
		if (head == null || head.next == null || head.next.next == null)
			return;
		else
		{
			List<Integer> list = new ArrayList<>();
			ListNode p = head;
			int count = 0;
			while (p != null)
			{
				list.add(p.val);
				count++;
				p = p.next;
			}
			Integer[] array = list.toArray(new Integer[count]);
			p = head;
			int i = 0;
			int a = 0;
			int b = count - 1;
			while (p != null)
			{
				if (i % 2 == 0)
				{
					p.val = array[a];
					a++;
				}
				else
				{
					p.val = array[b];
					b--;
				}
				i++;
				p = p.next;
			}
		}
	}
}
