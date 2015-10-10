package leetcode.algorithms;

// https://oj.leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {
  // time O(n), space O(1)
  public int climbStairs(int n) {
    if (n == 1) {
      return 1;
    }
    int p1 = 1, p2 = 1;
    for (int i = 2; i <= n; i++) {
      int p3 = p1 + p2;
      p1 = p2;
      p2 = p3;
    }
    return p2;
  }
}
