package leetcode;

public class ReverseWordsinaString
{
	public String reverseWords(String s)
	{
		if (s == null)
			return s;
		String[] words = s.trim().split(" ");
		if (words.length == 0)
			return "";
		StringBuffer result = new StringBuffer();
		for (int i = words.length - 1; i > 0; i--)
		{
			if (!words[i].equals(""))
			{
				result.append(words[i]);
				result.append(" ");
			}
		}
		result.append(words[0]);
		return result.toString();
	}

	public static void main(String[] args)
	{
		ReverseWordsinaString s = new ReverseWordsinaString();
		System.out.println(s.reverseWords("   a   b "));
	}
}
