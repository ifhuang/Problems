package leetcode.algorithms;

// https://oj.leetcode.com/problems/maximum-subarray/
public class MaximumSubarray {
  // time O(n), space O(1)
  public int maxSubArray(int[] nums) {
    int max = Integer.MIN_VALUE;
    int sum = 0;
    for (int num : nums) {
      sum = Math.max(sum, 0) + num;
      max = Math.max(max, sum);
    }
    return max;
  }

  // time O(nlogn), space O(1)
  public int maxSubArray2(int[] nums) {
    return helper(nums, 0, nums.length);
  }

  private int helper(int[] nums, int i, int j) {
    if (i == j) {
      return Integer.MIN_VALUE;
    }
    int mid = (i + j) >>> 1;
    int left = helper(nums, i, mid);
    int right = helper(nums, mid + 1, j);
    int lt = 0;
    int lmax = 0;
    for (int k = mid - 1; k >= i; k--) {
      lt += nums[k];
      lmax = Math.max(lmax, lt);
    }
    int rt = 0;
    int rmax = 0;
    for (int k = mid + 1; k < j; k++) {
      rt += nums[k];
      rmax = Math.max(rmax, rt);
    }
    int middle = lmax + nums[mid] + rmax;
    return Math.max(Math.max(left, right), middle);
  }
}
