package leetcode.algorithms;

// https://oj.leetcode.com/problems/jump-game-ii/
public class JumpGameII {
  // time O(n), space O(n)
  public int jump(int[] nums) {
    int n = nums.length;
    int[] s = new int[n];
    for (int i = 0, cur = 1; i < n - 1 && cur < n; i++) {
      while (cur <= i + nums[i] && cur < n) {
        s[cur++] = s[i] + 1;
      }
    }
    return s[n - 1];
  }

  // time O(n), space O(1)
  public int jump2(int[] nums) {
    int n = nums.length;
    int stepCount = 0;
    int lastJumpMax = 0;
    int currentJumpMax = 0;
    for (int i = 0; i < n - 1; i++) {
      currentJumpMax = Math.max(currentJumpMax, i + nums[i]);
      if (i == lastJumpMax) {
        stepCount++;
        lastJumpMax = currentJumpMax;
      }
    }
    return stepCount;
  }
}
