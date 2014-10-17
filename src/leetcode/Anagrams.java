package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Anagrams
{
	public List<String> anagrams(String[] strs)
	{
		List<String> list = new LinkedList<>();
		if (strs == null)
			return list;
		Map<Integer, String> map = new HashMap<>();
		for (int i = 0; i < strs.length; i++)
		{
			char[] tmp = strs[i].toCharArray();
			Arrays.sort(tmp);
			map.put(i, new String(tmp));
		}
		List<java.util.Map.Entry<Integer, String>> listMap = sortByValue(map,
				true);
		for (int i = 0; i < listMap.size() - 1; i++)
			if (listMap.get(i).getValue().equals(listMap.get(i + 1).getValue()))
			{
				String sample = listMap.get(i).getValue();
				list.add(strs[listMap.get(i).getKey()]);
				int j = i + 1;
				for (; j < listMap.size(); j++)
					if (listMap.get(j).getValue().equals(sample))
						list.add(strs[listMap.get(j).getKey()]);
					else
						break;
				i = j - 1;
			}
		return list;
	}

	private static <K, V extends Comparable<? super V>> List<java.util.Map.Entry<K, V>> sortByValue(
			Map<K, V> map, final boolean asc)
	{
		List<java.util.Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<java.util.Map.Entry<K, V>>()
		{
			@Override
			public int compare(java.util.Map.Entry<K, V> e1,
					java.util.Map.Entry<K, V> e2)
			{
				if (asc)
					return e1.getValue().compareTo(e2.getValue());
				else
					return e2.getValue().compareTo(e1.getValue());
			}
		});
		return list;
	}

	public static void main(String[] args)
	{
		Anagrams solution = new Anagrams();
		String[] strs = { "tea", "and", "ate", "eat", "dan" };
		System.out.println(solution.anagrams(strs));
	}
}