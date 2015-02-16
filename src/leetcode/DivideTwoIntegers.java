package leetcode;

// https://oj.leetcode.com/problems/divide-two-integers/
public class DivideTwoIntegers {
  public int divide(int dividend, int divisor) {
    int signa = dividend >= 0 ? 1 : -1;
    int signb = divisor >= 0 ? 1 : -1;
    long end = Math.abs((long) dividend);
    long sor = Math.abs((long) divisor);
    int ans = 0;
    while (end >= sor) {
      long tmp = sor;
      int i = 1;
      for (; tmp <= end; i++)
        tmp <<= 1;
      ans += 1 << (i - 2);
      end -= sor << (i - 2);
    }
    return signa * signb * ans;
  }
}
