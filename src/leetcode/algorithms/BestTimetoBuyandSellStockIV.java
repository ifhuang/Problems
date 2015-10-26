package leetcode.algorithms;

import java.util.Arrays;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
public class BestTimetoBuyandSellStockIV {
  public int maxProfit(int k, int[] prices) {
    int n = prices.length;
    if (k > n / 2) {
      int ans = 0;
      for (int i = 1; i < n; i++) {
        ans += Math.max(0, prices[i] - prices[i - 1]);
      }
      return ans;
    }
    int[] buy = new int[k + 1];
    Arrays.fill(buy, Integer.MIN_VALUE);
    int[] sell = new int[k + 1];
    for (int i = 0; i < n; i++) {
      for (int j = 1; j <= k; j++) {
        buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
        sell[j] = Math.max(sell[j], buy[j] + prices[i]);
      }
    }
    return sell[k];
  }
}
