package leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation
{
	public int evalRPN(String[] tokens)
	{
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < tokens.length; i++)
		{
			String string = tokens[i];
			if (string.equals("+"))
			{
				stack.push(stack.pop() + stack.pop());
			}
			else if (string.equals("-"))
			{
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b - a);
			}
			else if (string.equals("*"))
			{
				stack.push(stack.pop() * stack.pop());
			}
			else if (string.equals("/"))
			{
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b / a);
			}
			else
			{
				stack.push(Integer.parseInt(string));
			}
		}
		return stack.pop();
	}

	public static void main(String[] args)
	{
		EvaluateReversePolishNotation s = new EvaluateReversePolishNotation();
		System.out.println(s.evalRPN(new String[] { "4", "13", "5", "/", "+" }));
	}
}
