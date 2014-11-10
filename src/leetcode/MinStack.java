package leetcode;

import java.util.Stack;

public class MinStack
{
	private Stack<Integer> data = new Stack<>();
	private Stack<Integer> min = new Stack<>();

	public void push(int x)
	{
		data.push(x);
		if (min.isEmpty() || min.peek() >= x)
			min.push(x);
	}

	public void pop()
	{
		int x = data.pop();
		if (min.peek() == x)
			min.pop();
	}

	public int top()
	{
		return data.peek();
	}

	public int getMin()
	{
		return min.peek();
	}
}
