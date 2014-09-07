package leetcode;

import java.util.Stack;

public class LongestValidParentheses
{
	public int longestValidParentheses(String s)
	{
		if (s == null)
			return 0;
		Stack<Character> stack = new Stack<>();
		int length = 0;
		int maxLength = 0;
		for (int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			if (c == '(')
			{
				stack.push(c);
			}
			else if (c == ')')
			{
				if (stack.isEmpty())
				{
				}
				else
				{
					if (stack.contains('('))
					{
						stack.remove(stack.lastIndexOf('('));
						stack.push('2');
					}
					else
					{
						while (!stack.isEmpty())
						{
							stack.pop();
							length += 2;
						}
						maxLength = maxLength > length ? maxLength : length;
						length = 0;
					}
				}
			}
			else
			{
			}
		}
		if (stack.isEmpty())
		{
		}
		else
		{
			while (!stack.isEmpty())
			{
				char c = stack.pop();
				if (c == '2')
				{
					length += 2;
				}
				else if (c == '(')
				{
					maxLength = maxLength > length ? maxLength : length;
					length = 0;
				}
				else
				{
				}
			}
			maxLength = maxLength > length ? maxLength : length;
		}
		return maxLength;
	}
}
