package leetcode.algorithms;

// https://leetcode.com/problems/product-of-array-except-self/
public class ProductofArrayExceptSelf {
  // time O(n), space O(1)
  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];
    if (n == 0) {
      return ans;
    }
    int left = 1;
    for (int i = 0; i < n; i++) {
      ans[i] = left;
      left *= nums[i];
    }
    int right = 1;
    for (int i = n - 1; i >= 0; i--) {
      ans[i] *= right;
      right *= nums[i];
    }
    return ans;
  }
}
