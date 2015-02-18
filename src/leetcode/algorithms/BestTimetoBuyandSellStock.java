package leetcode.algorithms;

// https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimetoBuyandSellStock {
  public int maxProfit(int[] prices) {
    int ans = 0;
    int tmp = 0;
    for (int i = 1; i < prices.length; i++) {
      tmp += prices[i] - prices[i - 1];
      ans = Math.max(ans, tmp);
      tmp = Math.max(tmp, 0);
    }
    return ans;
  }
}
