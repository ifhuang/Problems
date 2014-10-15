package leetcode;

public class PalindromePartitioningII
{
	public int minCut(String s)
	{
		if (s == null || s.length() < 2)
			return 0;
		else
		{
			int[] ans = new int[s.length()];
			boolean[][] dp = new boolean[ans.length][ans.length];
			ans[0] = 0;
			dp[0][0] = true;
			for (int i = 1; i < ans.length; i++)
			{
				ans[i] = i;
				for (int j = 0; j <= i; j++)
				{
					if (j == i)
						dp[j][i] = true;
					else
					{
						if (s.charAt(j) == s.charAt(i))
							if (j + 1 == i)
								dp[j][i] = true;
							else
								dp[j][i] = dp[j + 1][i - 1];
					}
					if (dp[j][i])
					{
						if (j == 0)
							ans[i] = 0;
						else
							ans[i] = Math.min(ans[i], ans[j - 1] + 1);
					}
				}
			}
			return ans[ans.length - 1];
		}
	}

	public static void main(String[] args)
	{
		PalindromePartitioningII solution = new PalindromePartitioningII();
		System.out.println(solution.minCut("efe"));
	}
}