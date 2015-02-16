package leetcode;

// https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
public class BestTimetoBuyandSellStockIII {
  public int maxProfit(int[] prices) {
    int n = prices.length;
    if (n == 0)
      return 0;
    int[] profitYet = new int[n];
    int min = prices[0];
    for (int i = 1; i < n; i++) {
      profitYet[i] = Math.max(prices[i] - min, profitYet[i - 1]);
      min = Math.min(min, prices[i]);
    }
    int[] profitFrom = new int[n];
    int max = prices[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      profitFrom[i] = Math.max(max - prices[i], profitFrom[i + 1]);
      max = Math.max(max, prices[i]);
    }
    int ans = 0;
    for (int i = 0; i < n; i++)
      ans = Math.max(ans, profitYet[i] + profitFrom[i]);
    return ans;
  }
}
