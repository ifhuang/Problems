package leetcode;

// https://oj.leetcode.com/problems/implement-strstr/
public class ImplementstrStr
{
	public int strStr(String haystack, String needle)
	{
		int h = haystack.length();
		int n = needle.length();
		for (int i = 0, j = 0; i < h - n + 1;)
		{
			for (; j < n;)
				if (haystack.charAt(i) != needle.charAt(j))
					break;
				else
				{
					i++;
					j++;
				}
			if (j == n)
				return i - j;
			else
			{
				i = i - j + 1;
				j = 0;
			}
		}
		return -1;
	}
}
