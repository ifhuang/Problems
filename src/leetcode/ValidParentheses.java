package leetcode;

import java.util.Stack;

// https://oj.leetcode.com/problems/valid-parentheses/
public class ValidParentheses
{
	public boolean isValid(String s)
	{
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			switch (c)
			{
				case '(':
				case '{':
				case '[':
					stack.push(c);
					break;
				case ')':
					if (stack.isEmpty() || stack.pop() != '(')
						return false;
					break;
				case '}':
					if (stack.isEmpty() || stack.pop() != '{')
						return false;
					break;
				case ']':
					if (stack.isEmpty() || stack.pop() != '[')
						return false;
					break;
			}
		}
		return stack.isEmpty();
	}
}
