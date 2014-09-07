package leetcode;

public class ClimbingStairs
{
	public int climbStairs(int n)
	{
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		int[] result = new int[n];
		result[1] = 1;
		result[2] = 2;
		int i = 3;
		while (i < n)
		{
			result[i] = result[i - 1] + result[i - 2];
			i++;
		}
		return result[i - 1] + result[i - 2];
	}
}
