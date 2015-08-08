package leetcode.algorithms;

public class HouseRobber {

  public int rob(int[] num) {
    if (num.length == 0)
      return 0;
    int grandpa = 0;
    int father = num[0];
    if (num.length == 1)
      return father;
    int child = 0;
    for (int i = 2; i <= num.length; i++) {
      child = Math.max(father, num[i - 1] + grandpa);
      grandpa = father;
      father = child;
    }
    return child;
  }

  public int rob2(int[] nums) {
    int n = nums.length;
    int[][] dp = new int[n + 1][2];
    for (int i = 1; i <= n; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
      dp[i][1] = nums[i - 1] + dp[i - 1][0];
    }
    return Math.max(dp[n][0], dp[n][1]);
  }

  public int rob3(int[] nums) {
    int n = nums.length;
    int preNo = 0;
    int preYes = 0;
    for (int i = 1; i <= n; i++) {
      int nowNo = Math.max(preNo, preYes);
      int nowYes = nums[i - 1] + preNo;
      preNo = nowNo;
      preYes = nowYes;
    }
    return Math.max(preNo, preYes);
  }

}
