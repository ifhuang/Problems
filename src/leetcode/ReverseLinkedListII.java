package leetcode;

import leetcode.util.ListNode;

// https://oj.leetcode.com/problems/reverse-linked-list-ii/
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode now = head;
		ListNode post = head.next;
		while (m > 1) {
			m--;
			n--;
			pre = now;
			now = post;
			post = post.next;
		}
		while (n > 1) {
			n--;
			ListNode tmp = post;
			post = post.next;
			tmp.next = now;
			now = tmp;
		}
		pre.next.next = post;
		pre.next = now;
		return dummy.next;
	}
}
