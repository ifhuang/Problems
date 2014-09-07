package leetcode;

public class ImplementstrStr
{
	public String strStr(String haystack, String needle)
	{
		int index = haystack.indexOf(needle);
		if (index == -1)
			return null;
		return haystack.substring(index);
	}
}
