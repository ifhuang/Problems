package leetcode;

public class CountandSay
{
	public String countAndSay(int n)
	{
		if (n < 1)
			return "";
		String input = "1";
		n--;
		String result = input;
		while (n > 0)
		{
			result = count(result);
			n--;
		}
		return result;
	}

	private String count(String input)
	{
		if (input == null || input.equals(""))
		{
			return "";
		}
		StringBuffer sb = new StringBuffer();
		int count = 1;
		char c = input.charAt(0);
		for (int i = 1; i < input.length(); i++)
		{
			if (input.charAt(i) == c)
			{
				count++;
			}
			else
			{
				sb.append(count);
				sb.append(c);
				count = 1;
				c = input.charAt(i);
			}
		}
		sb.append(count);
		sb.append(c);
		return sb.toString();
	}
}
