package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder
{
	public int ladderLength(String start, String end, Set<String> dict)
	{
		if (start == null || end == null)
			return 0;
		if (start.equals(end))
			return 1;
		if (dict.size() == 0)
			return 0;
		Map<String, Integer> map = new HashMap<>();
		Queue<String> queue = new LinkedList<>();
		map.put(start, 1);
		queue.offer(start);
		while (!queue.isEmpty())
		{
			String now = queue.poll();
			if (now.equals(end))
				break;
			for (int i = 0; i < now.length(); i++)
			{
				StringBuilder sb = new StringBuilder(now);
				for (char c = 'a'; c <= 'z'; c++)
				{
					sb.setCharAt(i, c);
					String tmp = sb.toString();
					if (dict.contains(tmp) && !map.containsKey(tmp))
					{
						int count = map.get(now);
						map.put(tmp, count + 1);
						queue.offer(tmp);
					}
				}
			}
		}
		if (!map.containsKey(end))
			return 0;
		return map.get(end);
	}

	public static void main(String[] args)
	{
		WordLadder solution = new WordLadder();
		String[] strings = { "si", "go", "se", "cm", "so", "ph", "mt", "db",
				"mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci",
				"ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn",
				"ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au",
				"ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb",
				"if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li",
				"ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh",
				"wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne",
				"mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb",
				"ni", "mr", "pa", "he", "lr", "sq", "ye" };
		Set<String> dict = new HashSet<>();
		for (String string : strings)
			dict.add(string);
		System.out.println("" + solution.ladderLength("qa", "sq", dict));
	}
}