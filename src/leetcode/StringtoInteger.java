package leetcode;

public class StringtoInteger
{
	public int atoi(String str)
	{
		if (str == null || str.equals(""))
			return 0;

		int i = 0;
		for (; i < str.length(); i++)
		{
			if (str.charAt(i) != ' ' && str.charAt(i) != '\t'
					&& str.charAt(i) != '\n')
				break;
		}
		if (i == str.length())
			return 0;

		int flag = 1;
		if (str.charAt(i) == '+')
		{
			i++;
		}
		else if (str.charAt(i) == '-')
		{
			flag = -1;
			i++;
		}

		long result = 0;
		for (; i < str.length(); i++)
		{
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
			{
				result *= 10;
				result += str.charAt(i) - 48;
				if (flag == 1 && result >= Integer.MAX_VALUE)
					return Integer.MAX_VALUE;
				else if (flag == -1 && -result <= Integer.MIN_VALUE)
					return Integer.MIN_VALUE;
			}
			else
			{
				break;
			}
		}
		return flag * (int) result;
	}
}
