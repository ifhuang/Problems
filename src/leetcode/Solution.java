package leetcode;

import java.util.Stack;

import leetcode.util.ListNode;

public class Solution
{
	public void reorderList(ListNode head)
	{
		if (head == null || head.next == null || head.next.next == null)
			return;
		ListNode p = head;
		Stack<ListNode> stack = new Stack<>();
		while (p.next != null)
		{
			p = p.next;
			stack.push(p);
		}
		insert(head, stack);
	}

	private void insert(ListNode head, Stack<ListNode> stack)
	{
		if (head == null || head.next == null || head.next.next == null)
			return;
		ListNode p = stack.pop();
		ListNode pre = stack.peek();
		pre.next = p.next;
		p.next = head.next;
		head.next = p;
		insert(head.next.next, stack);
	}

	public static void main(String[] args) throws Exception
	{
		Solution solution = new Solution();
		ListNode list = ListNode.createListFromFile("data/list");
		solution.reorderList(list);
	}
}
