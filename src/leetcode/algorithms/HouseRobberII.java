package leetcode.algorithms;

// https://leetcode.com/problems/house-robber-ii/
public class HouseRobberII {
  public int rob(int[] nums) {
    int n = nums.length;
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return nums[0];
    }
    return Math.max(robHelper(nums, 0, n - 1), robHelper(nums, 1, n));
  }

  private int robHelper(int[] a, int start, int end) {
    int preNo = 0;
    int preYes = 0;
    for (int i = start; i < end; i++) {
      int nowNo = Math.max(preNo, preYes);
      int nowYes = a[i] + preNo;
      preNo = nowNo;
      preYes = nowYes;
    }
    return Math.max(preNo, preYes);
  }
}
