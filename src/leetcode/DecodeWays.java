package leetcode;

public class DecodeWays
{
	public int numDecodings(String s)
	{
		if (s == null || s.length() == 0 || s.charAt(0) == '0')
			return 0;
		else if (s.length() == 1)
			return s.length();
		else
		{
			int length = s.length();
			int[] dp = new int[length + 1];
			dp[0] = 1;
			dp[1] = 1;
			boolean flag = false;
			for (int i = 2; i < length + 1; i++)
			{
				char pre = s.charAt(i - 2);
				char now = s.charAt(i - 1);
				if (now == '0')
				{
					if (pre == '1' || pre == '2')
					{
						if (flag)
							dp[i] = dp[i - 1] - 1;
						else
							dp[i] = dp[i - 1];
						flag = false;
					}
					else
						return 0;
				}
				else
				{
					if (pre == '1' || (pre == '2' && now < '7'))
					{
						dp[i] = dp[i - 1] + dp[i - 2];
						flag = true;
					}
					else
					{
						dp[i] = dp[i - 1];
						flag = false;
					}
				}
			}
			return dp[length];
		}
	}

	public static void main(String[] args)
	{
		DecodeWays solution = new DecodeWays();
		System.out.println("" + solution.numDecodings("16205"));
	}
}