package leetcode;

// https://oj.leetcode.com/problems/wildcard-matching/
public class WildcardMatching
{
	public boolean isMatch(String s, String p)
	{
		int sIndex = 0, pIndex = 0, match = 0, starIndex = -1;
		while (sIndex < s.length())
			if (pIndex < p.length()
					&& (s.charAt(sIndex) == p.charAt(pIndex) || p
							.charAt(pIndex) == '?'))
			{
				sIndex++;
				pIndex++;
			}
			else if (pIndex < p.length() && p.charAt(pIndex) == '*')
			{
				starIndex = pIndex;
				match = sIndex;
				pIndex++;
			}
			else if (starIndex != -1)
			{
				pIndex = starIndex + 1;
				match++;
				sIndex = match;
			}
			else
				return false;
		while (pIndex < p.length() && p.charAt(pIndex) == '*')
			pIndex++;
		return pIndex == p.length();
	}
}