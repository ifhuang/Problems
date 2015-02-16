package leetcode;

// https://oj.leetcode.com/problems/jump-game-ii/
public class JumpGameII {
  public int jump(int[] A) {
    int len = A.length;
    int[] ans = new int[len];
    for (int i = 0, l = 1; i < len; i++)
      while (l < len && l - i <= A[i])
        ans[l++] = ans[i] + 1;
    return ans[len - 1];
  }
}
