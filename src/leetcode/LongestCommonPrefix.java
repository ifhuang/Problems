package leetcode;

public class LongestCommonPrefix
{
	public String longestCommonPrefix(String[] strs)
	{
		if (strs == null || strs.length == 0)
			return "";
		if (strs.length == 1)
			return strs[0];
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0;; i++)
		{
			if (i == strs[0].length())
				break;
			char c = strs[0].charAt(i);
			int j;
			for (j = 1; j < strs.length; j++)
			{
				if (i == strs[j].length())
					break;
				if (c != strs[j].charAt(i))
					break;
			}
			if (j == strs.length)
				stringBuffer.append(c);
			else
				break;
		}
		return stringBuffer.toString();
	}
}
