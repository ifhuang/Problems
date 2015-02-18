package leetcode.algorithms;

// https://oj.leetcode.com/problems/maximum-subarray/
public class MaximumSubarray {
  public int maxSubArray(int[] A) {
    int len = A.length;
    int maxSum = A[0];
    int tmpSum = A[0];
    for (int i = 1; i < len; i++) {
      if (tmpSum < 0)
        tmpSum = 0;
      tmpSum += A[i];
      maxSum = Math.max(maxSum, tmpSum);
    }
    return maxSum;
  }
}
