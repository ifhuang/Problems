package leetcode;

import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning
{
	public List<List<String>> partition(String s)
	{
		List<List<String>> list = new LinkedList<>();
		if (s == null || s.length() == 0)
			return list;
		else if (s.length() == 1)
		{
			List<String> item = new LinkedList<>();
			item.add(s);
			list.add(item);
			return list;
		}
		else
		{
			int length = s.length();
			for (int i = 1; i <= length; i++)
			{
				String pre = s.substring(0, i);
				String suf = s.substring(i);
				if (check(pre))
				{
					List<List<String>> sufList = partition(suf);
					for (List<String> list2 : sufList)
					{
						list2.add(0, pre);
						list.add(list2);
					}
					if (suf.length() == 0)
					{
						List<String> item = new LinkedList<>();
						item.add(pre);
						list.add(item);
					}
				}
			}
			return list;
		}
	}

	private boolean check(String s)
	{
		if (s.length() == 1)
			return true;
		int length = s.length();
		for (int i = 0; i < length / 2; i++)
			if (s.charAt(i) != s.charAt(length - 1 - i))
				return false;
		return true;
	}
}