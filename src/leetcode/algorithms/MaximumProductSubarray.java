package leetcode.algorithms;

// https://oj.leetcode.com/problems/maximum-product-subarray/
public class MaximumProductSubarray {
  public int maxProduct(int[] nums) {
    int large = 1;
    int small = 1;
    int ans = Integer.MIN_VALUE;
    for (int num : nums) {
      int copy = large;
      large = Math.max(num, Math.max(num * copy, num * small));
      small = Math.min(num, Math.min(num * copy, num * small));
      ans = Math.max(ans, large);
    }
    return ans;
  }
}
