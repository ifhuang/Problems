package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Combinations
{
	public List<List<Integer>> combine(int n, int k)
	{
		List<List<Integer>> list = new ArrayList<>();
		if (n < 1 || k < 1)
			return list;
		else
		{
			Stack<Integer> stack = new Stack<>();
			stack.push(1);
			int now = 2;
			while (true)
			{
				if (stack.size() < k)
				{
					if (now <= n)
					{
						stack.push(now);
						now++;
					}
					else if (!stack.isEmpty())
					{
						now = stack.pop() + 1;
					}
					else
					{
						break;
					}
				}
				else if (stack.size() == k)
				{
					List<Integer> item = new ArrayList<>();
					for (int i = 0; i < k; i++)
					{
						item.add(stack.elementAt(i));
					}
					list.add(item);
					now = stack.pop() + 1;
				}
				else
				{

				}
			}
			return list;
		}
	}

	public static void main(String[] args)
	{
		Combinations s = new Combinations();
		System.out.println(s.combine(2, 1));
	}
}
