package leetcode;

public class BestTimetoBuyandSellStockII
{
	public int maxProfit(int[] prices)
	{
		if (prices == null || prices.length < 2)
			return 0;
		int max = 0;
		for (int i = 0; i < prices.length - 1; i++)
		{
			int growth = prices[i + 1] - prices[i];
			if (growth > 0)
				max += growth;
		}
		return max;
	}
}
