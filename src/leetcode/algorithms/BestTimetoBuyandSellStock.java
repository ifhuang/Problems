package leetcode.algorithms;

// https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimetoBuyandSellStock {
  public int maxProfit(int[] prices) {
    int ans = 0;
    int cur = 0;
    for (int i = 1; i < prices.length; i++) {
      cur += prices[i] - prices[i - 1];
      ans = Math.max(ans, cur);
      cur = Math.max(cur, 0);
    }
    return ans;
  }
}
