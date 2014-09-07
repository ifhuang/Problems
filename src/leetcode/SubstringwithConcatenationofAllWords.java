package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class SubstringwithConcatenationofAllWords
{
	public ArrayList<Integer> findSubstring(String S, String[] L)
	{
		ArrayList<Integer> indexList = new ArrayList<>();
		if (S == null || S.equals("") || L == null || L.length == 0)
			return indexList;
		int m = L.length;
		int n = L[0].length();
		for (int i = 0; i < S.length() - m * n + 1; i++)
		{
			HashMap<String, Integer> map = new HashMap<>();
			for (int j = 0; j < m; j++)
			{
				if (map.containsKey(L[j]))
				{
					map.put(L[j], map.get(L[j]) + 1);
				}
				else
				{
					map.put(L[j], 1);
				}

			}
			int j = 0;
			for (; j < m; j++)
			{
				String string = S.substring(i + n * j, i + n * j + n);
				if (map.containsKey(string))
				{
					if (map.get(string) > 0)
					{
						map.put(string, map.get(string) - 1);
					}
					else
					{
						break;
					}
				}
				else
				{
					break;
				}
			}
			if (j == m)
			{
				indexList.add(i);
			}
		}
		return indexList;
	}
}
