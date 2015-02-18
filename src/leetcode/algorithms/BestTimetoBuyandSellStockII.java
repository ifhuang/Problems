package leetcode.algorithms;

// https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class BestTimetoBuyandSellStockII {
  public int maxProfit(int[] prices) {
    int ans = 0;
    for (int i = 1; i < prices.length; i++) {
      int tmp = prices[i] - prices[i - 1];
      ans += Math.max(tmp, 0);
    }
    return ans;
  }
}
