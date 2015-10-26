package leetcode.algorithms;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-size-subarray-sum/
public class MinimumSizeSubarraySum {
  // time O(n), space O(1)
  public int minSubArrayLen(int s, int[] nums) {
    int ans = Integer.MAX_VALUE;
    for (int i = 0, j = 0, t = 0; j < nums.length;) {
      if (t < s) {
        t += nums[j++];
      }
      while (t >= s) {
        ans = Math.min(ans, j - i);
        t -= nums[i++];
      }
    }
    return ans == Integer.MAX_VALUE ? 0 : ans;
  }

  // time O(nlogn), space O(n)
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
      if (j < 0) {
        j = -j - 1;
      }
      if (j < n + 1) {
        ans = Math.min(ans, j - i);
      }
    }
    return ans == Integer.MAX_VALUE ? 0 : ans;
  }
}
