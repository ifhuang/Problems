package leetcode.algorithms;

// https://oj.leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {
  public int climbStairs(int n) {
    if (n == 1)
      return 1;
    int[] ans = new int[n];
    ans[0] = 1;
    ans[1] = 2;
    for (int i = 2; i < n; i++)
      ans[i] = ans[i - 1] + ans[i - 2];
    return ans[n - 1];
  }
}
