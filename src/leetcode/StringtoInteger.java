package leetcode;

// https://oj.leetcode.com/problems/string-to-integer-atoi/
public class StringtoInteger
{
	public int atoi(String str)
	{
		if (str == null || str.length() == 0)
			return 0;
		int n = str.length();
		int now = 0;
		while (now < n && Character.isWhitespace(str.charAt(now)))
			now++;
		if (now == n)
			return 0;
		int sign = 1;
		if (str.charAt(now) == '-')
		{
			sign = -1;
			now++;
		}
		else if (str.charAt(now) == '+')
			now++;
		long sum = 0;
		while (now < n)
		{
			char c = str.charAt(now);
			if (!Character.isDigit(c))
				break;
			int next = Character.getNumericValue(c);
			sum *= 10;
			sum += next;
			if (sign == 1 && sum >= Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			else if (sign == -1 && sum - 1 >= Integer.MAX_VALUE) // careful
				return Integer.MIN_VALUE;
			now++;
		}
		return sign * (int) sum;
	}
}
