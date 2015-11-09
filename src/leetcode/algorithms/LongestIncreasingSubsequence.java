package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequence {
  // time O(n^2), space O(n)
  public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    int ans = 0;
    for (int i = 0; i < n; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      ans = Math.max(ans, dp[i]);
    }
    return ans;
  }

  // time O(nlogn), space O(n)
  public int lengthOfLIS2(int[] nums) {
    List<Integer> list = new ArrayList<>();
    for (int num : nums) {
      helper(list, num);
    }
    return list.size();
  }

  private void helper(List<Integer> list, int num) {
    int low = 0, high = list.size();
    while (low < high) {
      int mid = (low + high) >>> 1;
      if (list.get(mid) < num) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    if (low == list.size()) {
      list.add(num);
    } else {
      list.set(low, num);
    }
  }
}
