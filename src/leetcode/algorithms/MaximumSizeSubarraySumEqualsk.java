package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
// Given an array nums and a target value k, find the maximum length of a subarray that sums to k.
// If there isn't one, return 0 instead.
// Example 1:
// Given nums = [1, -1, 5, -2, 3], k = 3,
// return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
// Example 2:
// Given nums = [-2, -1, 2, 1], k = 1,
// return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
// Follow Up:
// Can you do it in O(n) time?
public class MaximumSizeSubarraySumEqualsk {
  // time O(n^2), space O(n)
  public int maxSubArrayLen(int[] nums, int k) {
    int n = nums.length;
    int[] preSum = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      preSum[i] = preSum[i - 1] + nums[i - 1];
    }
    for (int len = n; len > 0; len--) {
      for (int i = 0; i + len <= n; i++) {
        if (preSum[i + len] - preSum[i] == k) {
          return len;
        }
      }
    }
    return 0;
  }

  // time O(n), space O(n^2)
  public int maxSubArrayLen2(int[] nums, int k) {
    int n = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    int sum = 0;
    int max = 0;
    for (int i = 0; i < n; i++) {
      sum += nums[i];
      if (sum == k) {
        max = i + 1;
      } else if (map.containsKey(sum - k)) {
        max = Math.max(max, i - map.get(sum - k));
      }
      if (!map.containsKey(sum)) {
        map.put(sum, i);
      }
    }
    return max;
  }
}
