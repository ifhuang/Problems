package leetcode;

public class ValidPalindrome
{
	public boolean isPalindrome(String s)
	{
		if (s == null)
			return true;
		String string = filter(s);
		return check(string);
	}

	private String filter(String s)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			c = Character.toLowerCase(c);
			if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9')
				sb.append(c);
		}
		return sb.toString();
	}

	private boolean check(String string)
	{
		if (string.length() < 2)
			return true;
		else
		{
			int mid = string.length() / 2;
			for (int i = 0; i < mid; i++)
				if (string.charAt(i) != string.charAt(string.length() - 1 - i))
					return false;
			return true;
		}
	}
}
