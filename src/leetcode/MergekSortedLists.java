package leetcode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import leetcode.util.ListNode;

// https://oj.leetcode.com/problems/merge-k-sorted-lists/
public class MergekSortedLists
{
	public ListNode mergeKLists(List<ListNode> lists)
	{
		if (lists == null || lists.size() == 0)
			return null;
		PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.size(),
				new Comparator<ListNode>()
				{
					@Override
					public int compare(ListNode arg0, ListNode arg1)
					{
						return arg0.val - arg1.val;
					}
				});
		for (ListNode list : lists)
			if (list != null)
				pq.add(list);
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		while (!pq.isEmpty())
		{
			p.next = pq.poll();
			p = p.next;
			if (p.next != null)
				pq.add(p.next);
		}
		return dummy.next;
	}
}
