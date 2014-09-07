package leetcode;

public class LongestPalindromicSubstring
{
	public String longestPalindrome(String s)
	{
		if (s == null || s.equals("") || s.length() == 1)
			return s;
		int length = s.length();
		boolean[][] isPalindrome = new boolean[length][length];
		for (int i = 0; i < length; i++)
		{
			isPalindrome[i][i] = true;
			if (i != length - 1 && s.charAt(i) == s.charAt(i + 1))
			{
				isPalindrome[i][i + 1] = true;
			}
		}
		for (int d = 2; d < length; d++)
		{
			for (int i = 0; i + d < length; i++)
			{
				if (s.charAt(i) == s.charAt(i + d)
						&& isPalindrome[i + 1][i + d - 1])
					isPalindrome[i][i + d] = true;
			}
		}
		for (int d = length - 1; d > 0; d--)
		{
			for (int i = 0; i + d < length; i++)
			{
				if (isPalindrome[i][i + d])
				{
					return s.substring(i, i + d + 1);
				}
			}
		}
		return s.substring(0, 0);
	}
}
