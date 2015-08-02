package leetcode.algorithms;

import java.util.Arrays;

public class MinimumSizeSubarraySum {
  public int minSubArrayLen(int s, int[] nums) {
    int ans = Integer.MAX_VALUE;
    int p1 = -1, p2 = -1, t = 0;
    int n = nums.length;
    while (true) {
      if (t < s) {
        p2++;
        if (p2 == n) {
          break;
        }
        t += nums[p2];
      } else {
        ans = Math.min(ans, p2 - p1);
        p1++;
        t -= nums[p1];
      }
    }
    return ans == Integer.MAX_VALUE ? 0 : ans;
  }

  public int minSubArrayLen2(int s, int[] nums) {
    int n = nums.length;
    int[] preSum = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      preSum[i] = preSum[i - 1] + nums[i - 1];
    }
    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      int t = s + preSum[i];
      int j = Arrays.binarySearch(preSum, i + 1, n + 1, t);
      if (j < 0)
        j = -j - 1;
      if (j < n + 1)
        ans = Math.min(ans, j - i);
    }
    return ans == Integer.MAX_VALUE ? 0 : ans;
  }
}
