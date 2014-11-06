package leetcode;

public class MinimumWindowSubstring
{
	public String minWindow(String S, String T)
	{
		if (S == null || T == null || S.length() == 0 || T.length() == 0
				|| S.length() < T.length())
			return "";
		int sL = S.length();
		int tL = T.length();
		int[] count = new int[128];
		boolean[] in = new boolean[128];
		int all = tL;
		for (int i = 0; i < tL; i++)
		{
			count[T.charAt(i) - 'A']++;
			in[T.charAt(i) - 'A'] = true;
		}
		int i = -1;
		int j = 0;
		int start = 0;
		int length = Integer.MAX_VALUE;
		while (i < sL && j < sL)
		{
			if (all > 0)
			{
				i++;
				if (i == sL)
					break;
				count[S.charAt(i) - 'A']--;
				if (in[S.charAt(i) - 'A'] && count[S.charAt(i) - 'A'] >= 0)
					all--;
			}
			else
			{
				if (length > i - j + 1)
				{
					start = j;
					length = i - j + 1;
				}
				count[S.charAt(j) - 'A']++;
				if (in[S.charAt(j) - 'A'] && count[S.charAt(j) - 'A'] > 0)
					all++;
				j++;
			}
		}
		if (length == Integer.MAX_VALUE)
			return "";
		else
			return S.substring(start, start + length);
	}
}
