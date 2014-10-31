package leetcode;

public class DistinctSubsequences
{
	public int numDistinct(String S, String T)
	{
		if (S == null || T == null)
			return 0;
		int sL = S.length();
		int tL = T.length();
		if (sL == 0 || tL == 0 || sL < tL)
			return 0;
		int[][] dp = new int[tL][sL];

		dp[0][0] = S.charAt(0) == T.charAt(0) ? 1 : 0;
		for (int i = 1; i < sL; i++)
			dp[0][i] = S.charAt(i) == T.charAt(0) ? dp[0][i - 1] + 1
					: dp[0][i - 1];
		for (int i = 1; i < tL; i++)
		{
			dp[i][i] = S.charAt(i) == T.charAt(i) && dp[i - 1][i - 1] == 1 ? 1
					: 0;
			for (int j = i + 1; j < sL; j++)
				if (S.charAt(j) == T.charAt(i))
					dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
				else
					dp[i][j] = dp[i][j - 1];
		}
		return dp[tL - 1][sL - 1];
	}

	public static void main(String[] args)
	{
		DistinctSubsequences solution = new DistinctSubsequences();
		System.out.println("" + solution.numDistinct("aabb", "ab"));
	}
}