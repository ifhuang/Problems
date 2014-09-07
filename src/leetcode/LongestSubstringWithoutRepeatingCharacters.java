package leetcode;

public class LongestSubstringWithoutRepeatingCharacters
{
	public int lengthOfLongestSubstring(String s)
	{
		if (s == null || s.equals(""))
			return 0;
		int max = 0;
		int last = 0;
		boolean[] flag = new boolean[256];

		for (int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			if (flag[c])
			{
				max = Math.max(max, i - last);
				int k;
				for (k = last; s.charAt(k) != c; k++)
					flag[s.charAt(k)] = false;
				last = k + 1;
			}
			else
			{
				flag[c] = true;
			}
		}
		max = Math.max(max, s.length() - last);
		return max;
	}
}
