package leetcode;

public class LengthofLastWord
{
	public int lengthOfLastWord(String s)
	{
		if (s == null || s.length() == 0)
			return 0;
		int i = s.length() - 1;
		for (; i >= 0 && s.charAt(i) == ' '; i--)
			;
		if (i < 0)
			return 0;
		int length = 0;
		for (; i >= 0 && s.charAt(i) != ' '; i--, length++)
			;
		return length;
	}
}
