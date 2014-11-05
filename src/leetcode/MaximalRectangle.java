package leetcode;

import java.util.Stack;

public class MaximalRectangle
{
	public int maximalRectangle(char[][] matrix)
	{
		if (matrix == null || matrix.length == 0 || matrix[0] == null
				|| matrix[0].length == 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] heightMatrix = new int[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (matrix[i][j] == '1')
					heightMatrix[i][j] = i == 0 ? 1
							: heightMatrix[i - 1][j] + 1;
		int max = 0;
		for (int i = 0; i < m; i++)
			max = Math.max(max, largestRectangleArea(heightMatrix[i]));
		return max;
	}

	private int largestRectangleArea(int[] height)
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