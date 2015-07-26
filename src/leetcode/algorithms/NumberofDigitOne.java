package leetcode.algorithms;

public class NumberofDigitOne {
  public int countDigitOne(int n) {
    int ans = 0;
    for (long i = 1; i <= n; i *= 10) {
      long a = n / i;
      long b = n % i;
      ans += (a + 8) / 10 * i + (a % 10 == 1 ? b + 1 : 0);
    }
    return ans;
  }
}
