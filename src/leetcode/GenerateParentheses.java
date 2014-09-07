package leetcode;

import java.util.ArrayList;
import java.util.HashSet;

public class GenerateParentheses
{
	public ArrayList<String> generateParenthesis(int n)
	{
		if (n < 1)
		{
			return null;
		}
		else if (n == 1)
		{
			String string = "()";
			ArrayList<String> list = new ArrayList<>();
			list.add(string);
			return list;
		}
		else
		{
			ArrayList<String> list = generateParenthesis(n - 1);
			HashSet<String> set = new HashSet<>();
			for (String string : list)
			{
				StringBuffer sb = new StringBuffer(string);
				for (int i = 0; i < sb.length(); i++)
				{
					StringBuffer sb2 = new StringBuffer(sb);
					sb2.insert(i, '(');
					for (int j = i + 1; j < sb2.length(); j++)
					{
						StringBuffer sb3 = new StringBuffer(sb2);
						sb3.insert(j, ')');
						set.add(sb3.toString());
					}
				}
			}
			ArrayList<String> result = new ArrayList<>();
			for (String string : set)
			{
				result.add(string);
			}
			return result;
		}
	}
}
