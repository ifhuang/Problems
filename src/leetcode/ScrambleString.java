package leetcode;

import java.util.Arrays;

public class ScrambleString
{
	public boolean isScramble(String s1, String s2)
	{
		if (s1 == null && s2 == null)
			return true;
		else if (s1 == null || s2 == null || s1.length() != s2.length())
			return false;
		else if (s1.equals(s2))
			return true;
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		for (int i = 0; i < c1.length; i++)
			if (c1[i] != c2[i])
				return false;
		for (int i = 1; i < c1.length; i++)
			if ((isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(
					s1.substring(i), s2.substring(i)))
					|| (isScramble(s1.substring(0, i),
							s2.substring(c1.length - i)) && isScramble(
							s1.substring(i), s2.substring(0, c1.length - i))))
				return true;
		return false;
	}

	public static void main(String[] args)
	{
		ScrambleString solution = new ScrambleString();
		System.out.println(solution.isScramble("abc", "bca"));
	}
}