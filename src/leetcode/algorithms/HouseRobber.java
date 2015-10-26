package leetcode.algorithms;

// https://leetcode.com/problems/house-robber/
public class HouseRobber {

  // time O(n), space O(n)
  public int rob(int[] nums) {
    int n = nums.length;
    int[][] dp = new int[n + 1][2];
    for (int i = 1; i <= n; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
      dp[i][1] = nums[i - 1] + dp[i - 1][0];
    }
    return Math.max(dp[n][0], dp[n][1]);
  }

  // time O(n), space O(1)
  public int rob3(int[] nums) {
    int n = nums.length;
    int preNo = 0;
    int preYes = 0;
    for (int i = 0; i < n; i++) {
      int nowNo = Math.max(preNo, preYes);
      int nowYes = nums[i] + preNo;
      preNo = nowNo;
      preYes = nowYes;
    }
    return Math.max(preNo, preYes);
  }

}
