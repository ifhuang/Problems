package leetcode;

// https://oj.leetcode.com/problems/jump-game/
public class JumpGame {
  public boolean canJump(int[] A) {
    int len = A.length;
    int last = len - 1;
    for (int i = len - 2; i >= 0; i--)
      if (A[i] + i >= last)
        last = i;
    return last == 0;
  }
}
