package leetcode.algorithms;

// https://oj.leetcode.com/problems/jump-game/
public class JumpGame {
  // time O(n), space O(1)
  public boolean canJump(int[] nums) {
    int n = nums.length;
    int j = 0;
    for (int i = 0; i <= j && j < n - 1; i++) {
      j = Math.max(j, i + nums[i]);
    }
    return j >= n - 1;
  }
}
