package leetcode.algorithms;

// https://oj.leetcode.com/problems/divide-two-integers/
public class DivideTwoIntegers {
  // time O(logn), space O(1)
  public int divide(int dividend, int divisor) {
    int signA = dividend < 0 ? -1 : 1;
    int signB = divisor < 0 ? -1 : 1;
    long a = Math.abs((long) dividend);
    long b = Math.abs((long) divisor);
    long ans = 0;
    while (a >= b) {
      long c = b;
      long d = 1;
      while (c <= a) {
        c <<= 1;
        d <<= 1;
      }
      c >>= 1;
      d >>= 1;
      a -= c;
      ans += d;
    }
    ans *= signA * signB;
    if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
      return Integer.MAX_VALUE;
    }
    return (int) ans;
  }
}
