package leetcode;

// https://oj.leetcode.com/problems/maximum-product-subarray/
public class MaximumProductSubarray {
  public int maxProduct(int[] A) {
    int n = A.length;
    int large = A[0];
    int small = A[0];
    int ans = A[0];
    for (int i = 1; i < n; i++) {
      int copy = large;
      large = Math.max(A[i], Math.max(copy * A[i], small * A[i]));
      small = Math.min(A[i], Math.min(copy * A[i], small * A[i]));
      ans = Math.max(ans, large);
    }
    return ans;
  }
}
