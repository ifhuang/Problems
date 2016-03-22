package leetcode.algorithms;

// https://leetcode.com/problems/increasing-triplet-subsequence/
public class IncreasingTripletSubsequence {
  // time O(n), space O(n)
  public boolean increasingTriplet(int[] nums) {
    int n = nums.length;
    int[] min = new int[n];
    for (int i = 0; i < n; i++) {
      min[i] = i == 0 ? nums[0] : Math.min(min[i - 1], nums[i]);
    }
    int[] max = new int[n];
    for (int i = n - 1; i >= 0; i--) {
      max[i] = i == n - 1 ? nums[n - 1] : Math.max(max[i + 1], nums[i]);
    }
    for (int i = 0; i < n; i++) {
      if (min[i] < nums[i] && nums[i] < max[i]) {
        return true;
      }
    }
    return false;
  }

  // time O(n), space O(1)
  public boolean increasingTriplet2(int[] nums) {
    int min = Integer.MAX_VALUE;
    int secondMin = Integer.MAX_VALUE;
    for (int num : nums) {
      if (num <= min) {
        min = num;
      } else if (num < secondMin) {
        secondMin = num;
      } else if (num > secondMin) {
        return true;
      }
    }
    return false;
  }
}
