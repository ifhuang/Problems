package leetcode;

public class UniquePaths
{
	public int uniquePaths(int m, int n)
	{
		if (m > n)
		{
			int t = m;
			m = n;
			n = t;
		}
		long up = 1;
		for (int i = 1; i < m; i++)
			up *= n - 1 + i;
		long down = 1;
		for (int i = 1; i < m; i++)
			down *= i;
		return (int) (up / down);
	}
}
