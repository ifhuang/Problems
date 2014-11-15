package leetcode;

// https://oj.leetcode.com/problems/reverse-integer/
public class ReverseInteger
{
	public int reverse(int x)
	{
		int sign = x > 0 ? 1 : -1;
		int abs = Math.abs(x);
		if (abs < 0)
			return 0;
		int sum = 0;
		int bound1 = Integer.MAX_VALUE / 10;
		int bound2 = Integer.MAX_VALUE % 10;
		while (abs != 0)
		{
			int last = abs % 10;
			if (sum > bound1 || (sum == bound1 && last > bound2))
				return 0;
			sum *= 10;
			sum += last;
			abs /= 10;
		}
		return sign * sum;
	}
}
