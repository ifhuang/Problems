package leetcode.algorithms;

// https://oj.leetcode.com/problems/powx-n/
public class Powxn {
  // time O(logn), space O(1)
  public double myPow(double x, int n) {
    if (n == 0) {
      return 1.0;
    } else if (n == Integer.MIN_VALUE) {
      return Double.compare(x, 1) == 0 || Double.compare(x, -1) == 0 ? 1 : 0;
    } else if (n < 0) {
      return 1.0 / myPow(x, -n);
    }
    double half = myPow(x, n / 2);
    double ans = half * half;
    return n % 2 == 0 ? ans : ans * x;
  }
}
