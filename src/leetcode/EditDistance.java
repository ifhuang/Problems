package leetcode;

public class EditDistance
{
	public int minDistance(String word1, String word2)
	{
		if (word1 == null || word1.equals(""))
			return word2.length();
		if (word2 == null || word2.equals(""))
			return word1.length();
		int M = word1.length() + 1;
		int N = word2.length() + 1;
		int[][] dp = new int[N][M];
		dp[0][0] = 0;
		for (int i = 1; i < M; i++)
			dp[0][i] = i;
		for (int i = 1; i < N; i++)
			dp[i][0] = i;

		int tmp;
		for (int i = 1; i < N; i++)
		{
			for (int j = 1; j < M; j++)
			{
				if (word2.charAt(i - 1) == word1.charAt(j - 1))
					tmp = dp[i - 1][j - 1];
				else
					tmp = dp[i - 1][j - 1] + 1;
				dp[i][j] = Math.min(Math.min(tmp, dp[i - 1][j] + 1),
						dp[i][j - 1] + 1);
			}
		}
		return dp[N - 1][M - 1];
	}
}
