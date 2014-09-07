package leetcode;

public class ReverseInteger
{
	public int reverse(int x)
	{
		if (x == 0)
		{
			return 0;
		}
		else if (x > 0)
		{
			int sum = 0;
			for (; x != 0; x /= 10)
			{
				int now = x % 10;
				sum *= 10;
				sum += now;
			}
			return sum;
		}
		else
		{
			x = -x;
			int sum = 0;
			for (; x != 0; x /= 10)
			{
				int now = x % 10;
				sum *= 10;
				sum += now;
			}
			return -sum;
		}
	}
}
