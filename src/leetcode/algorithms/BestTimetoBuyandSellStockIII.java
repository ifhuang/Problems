package leetcode.algorithms;

// https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
public class BestTimetoBuyandSellStockIII {
  public int maxProfit(int[] prices) {
    int n = prices.length;
    int[] left = new int[n];
    int t1 = 0;
    for (int i = 1; i < n; i++) {
      t1 += prices[i] - prices[i - 1];
      left[i] = Math.max(left[i - 1], t1);
      t1 = Math.max(t1, 0);
    }
    int[] right = new int[n];
    int t2 = 0;
    for (int i = n - 2; i >= 0; i--) {
      t2 += prices[i + 1] - prices[i];
      right[i] = Math.max(right[i + 1], t2);
      t2 = Math.max(t2, 0);
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
      ans = Math.max(ans, left[i] + right[i]);
    }
    return ans;
  }
}
