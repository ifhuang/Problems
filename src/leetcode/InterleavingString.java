package leetcode;

public class InterleavingString
{
	public boolean isInterleave(String s1, String s2, String s3)
	{
		if (s1 == null && s2 == null)
			return s3 == null;
		else if (s1 == null)
			return s2.equals(s3);
		else if (s2 == null)
			return s1.equals(s3);

		int l1 = s1.length();
		int l2 = s2.length();
		int l3 = s3.length();
		if (l1 + l2 != l3)
			return false;
		boolean[][] dp = new boolean[l1 + 1][l2 + 1];
		for (int i = 0; i < l1 + 1; i++)
			for (int j = 0; j < l2 + 1; j++)
				if (i == 0 && j == 0)
					dp[0][0] = true;
				else if (i == 0)
					dp[0][j] = dp[0][j - 1]
							&& s2.charAt(j - 1) == s3.charAt(j - 1);
				else if (j == 0)
					dp[i][0] = dp[i - 1][0]
							&& s1.charAt(i - 1) == s3.charAt(i - 1);
				else
					dp[i][j] = (dp[i][j] = dp[i][j - 1]
							&& s2.charAt(j - 1) == s3.charAt(i + j - 1))
							|| (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i
									+ j - 1));
		return dp[l1][l2];
	}
}