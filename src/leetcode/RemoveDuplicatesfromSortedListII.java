package leetcode;

import leetcode.util.ListNode;

public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;
		ListNode p = head.next;
		while (p != null && head.val == p.val)
			p = p.next;
		if (p == head.next) {
			head.next = deleteDuplicates(p);
			return head;
		} else
			return deleteDuplicates(p);
	}
}
