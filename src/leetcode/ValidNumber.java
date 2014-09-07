package leetcode;

public class ValidNumber
{
	public boolean isNumber(String s)
	{
		if (s == null || s.length() == 0)
			return false;
		if (s.charAt(s.length() - 1) >= 'a' && s.charAt(s.length() - 1) <= 'z'
				|| s.charAt(s.length() - 1) >= 'A'
				&& s.charAt(s.length() - 1) <= 'Z')
			return false;
		try
		{
			Integer.parseInt(s);
			return true;
		}
		catch (Exception e)
		{
		}
		try
		{
			Double.parseDouble(s);
			return true;
		}
		catch (Exception e)
		{
		}
		return false;
	}

	public static void main(String[] args)
	{

	}
}
