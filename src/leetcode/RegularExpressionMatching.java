package leetcode;

public class RegularExpressionMatching
{
	public boolean isMatch(String s, String p)
	{
		return java.util.regex.Pattern.matches(p, s);
	}
}
