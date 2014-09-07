package leetcode;

public class PlusOne
{
	public int[] plusOne(int[] digits)
	{
		int n = digits.length;
		if (digits[n - 1] < 9)
		{
			digits[n - 1]++;
			return digits;
		}
		else
		{
			digits[n - 1] = 0;
			int i = 2;
			for (; i <= n; i++)
			{
				if (digits[n - i] < 9)
				{
					digits[n - i]++;
					break;
				}
				else
				{
					digits[n - i] = 0;
				}
			}
			if (i > n)
			{
				digits = new int[n + 1];
				digits[0] = 1;
				for (int j = 0; j < n; j++)
				{
					digits[j + 1] = 0;
				}
			}
			return digits;
		}
	}
}
