package leetcode;

public class BestTimetoBuyandSellStockIII
{
	public int maxProfit(int[] prices)
	{
		if (prices == null || prices.length < 2)
			return 0;
		int length = prices.length;
		int[] from = new int[length];
		from[length - 1] = 0;
		int fromMax = prices[length - 1];
		for (int i = length - 2; i >= 0; i--)
		{
			int diff = fromMax - prices[i];
			from[i] = Math.max(diff, from[i + 1]);
			fromMax = Math.max(fromMax, prices[i]);
		}

		int[] to = new int[length];
		to[0] = 0;
		int toMin = prices[0];
		for (int i = 1; i < length; i++)
		{
			int diff = prices[i] - toMin;
			to[i] = Math.max(diff, to[i - 1]);
			toMin = Math.min(toMin, prices[i]);
		}

		int max = 0;
		for (int i = 0; i < to.length; i++)
			max = Math.max(from[i] + to[i], max);
		return max;
	}

	public static void main(String[] args)
	{
		BestTimetoBuyandSellStockIII solution = new BestTimetoBuyandSellStockIII();
		System.out.println(solution.maxProfit(new int[] { 2, 1, 2, 0, 1 }));
	}
}