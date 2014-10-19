package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII
{
	public List<String> wordBreak(String s, Set<String> dict)
	{
		List<String> list = new LinkedList<>();
		if (s == null || s.length() == 0)
			return list;
		if (dict == null || dict.size() == 0)
			return list;

		list.add("");
		int length = s.length() + 1;
		Map<Integer, List<String>> dp = new HashMap<>(length);
		dp.put(length - 1, list);
		for (int i = length - 2; i >= 0; i--)
		{
			List<String> copyItem = new LinkedList<>();
			for (int j = i + 1; j < length; j++)
				if (dict.contains(s.substring(i, j)))
				{
					List<String> item = dp.get(j);
					for (String string : item)
					{
						if (string.equals(""))
							copyItem.add(s.substring(i, j));
						else
							copyItem.add(s.substring(i, j) + " " + string);
					}
				}
			dp.put(i, copyItem);
		}
		return dp.get(0);
	}

	public static void main(String[] args)
	{
		WordBreakII solution = new WordBreakII();
		Set<String> dict = new HashSet<>();
		dict.add("b");
		System.out.println(solution.wordBreak("a", dict));

	}
}