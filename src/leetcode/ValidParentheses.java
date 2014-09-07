package leetcode;

import java.util.Stack;

public class ValidParentheses
{
	public boolean isValid(String s)
	{
		if (s == null || s.equals(""))
			return true;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++)
		{
			switch (s.charAt(i))
			{
				case '(':
				case '[':
				case '{':
					stack.push(s.charAt(i));
					break;
				case ')':
					if (stack.isEmpty())
					{
						return false;
					}
					else
					{
						if (stack.pop() != '(')
							return false;
					}
					break;
				case ']':
					if (stack.isEmpty())
					{
						return false;
					}
					else
					{
						if (stack.pop() != '[')
							return false;
					}
					break;
				case '}':
					if (stack.isEmpty())
					{
						return false;
					}
					else
					{
						if (stack.pop() != '{')
							return false;
					}
					break;
				default:
					break;
			}
		}
		if (stack.isEmpty())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
