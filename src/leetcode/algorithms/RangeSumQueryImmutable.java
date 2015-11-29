package leetcode.algorithms;

// https://leetcode.com/problems/range-sum-query-immutable/
public class RangeSumQueryImmutable {
  private int[] preSum;

  public RangeSumQueryImmutable(int[] nums) {
    preSum = new int[nums.length + 1];
    for (int i = 1; i <= nums.length; i++) {
      preSum[i] = preSum[i - 1] + nums[i - 1];
    }
  }

  public int sumRange(int i, int j) {
    return preSum[j + 1] - preSum[i];
  }
}
