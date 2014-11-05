package leetcode;

import java.util.Stack;

public class LargestRectangleinHistogram
{
	public int largestRectangleArea(int[] height)
	{
		if (height == null || height.length == 0)
			return 0;
		else if (height.length == 1)
			return height[0];
		int max = 0;
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		while (i < height.length)
			if (stack.isEmpty() || height[stack.peek()] < height[i])
				stack.push(i++);
			else
			{
				int top = stack.pop();
				int tmp = height[top]
						* (stack.isEmpty() ? i : i - stack.peek() - 1);
				max = Math.max(max, tmp);
			}
		while (!stack.isEmpty())
		{
			int top = stack.pop();
			int tmp = height[top]
					* (stack.isEmpty() ? i : i - stack.peek() - 1);
			max = Math.max(max, tmp);
		}
		return max;
	}
}