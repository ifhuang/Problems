package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import leetcode.util.ListNode;

public class SortList
{
	public ListNode sortList(ListNode head)
	{
		if (head == null || head.next == null)
			return head;
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
			Arrays.sort(array);
			p = head;
			int i = 0;
			while (p != null)
			{
				p.val = array[i];
				i++;
				p = p.next;
			}
			return head;
		}
	}
}
