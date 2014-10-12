package leetcode;

import java.util.HashSet;
import java.util.Set;

public class WordBreak
{
	public boolean wordBreak(String s, Set<String> dict)
	{
		if (s == null || s.length() == 0)
			return true;
		if (dict == null || dict.size() == 0)
			return false;
		boolean[] dp = new boolean[s.length() + 1];
		int length = dp.length;
		dp[0] = true;
		for (int i = 1; i < dp.length; i++)
			for (int j = 0; j < i; j++)
				if (dp[j] && dict.contains(s.substring(j, i)))
				{
					dp[i] = true;
					break;
				}
		return dp[length - 1];
	}

	public static void main(String[] args)
	{
		WordBreak solution = new WordBreak();
		String s = "abcd";
		Set<String> set = new HashSet<>();
		set.add("a");
		set.add("abc");
		set.add("b");
		set.add("cd");
		System.out.println("" + solution.wordBreak(s, set));
	}
}