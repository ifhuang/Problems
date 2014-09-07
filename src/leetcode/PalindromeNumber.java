package leetcode;

public class PalindromeNumber
{
	public boolean isPalindrome(int x)
	{
		if (x < 10 && x > -1)
			return true;
		if (x < 0)
			return false;

		int n = 1;
		int y = x;
		while ((y /= 10) != 0)
		{
			n++;
		}

		while (n > 1)
		{
			int i = x % 10;
			int j = (int) (x / Math.pow(10, n - 1));
			if (i != j)
				return false;
			x -= j * Math.pow(10, n - 1);
			x /= 10;
			n -= 2;
		}
		return true;
	}
}
