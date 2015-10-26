package leetcode.algorithms;

// https://leetcode.com/problems/factorial-trailing-zeroes/
public class FactorialTrailingZeroes {
  public int trailingZeroes(int n) {
    int ans = 0;
    while (n > 0) {
      n /= 5;
      ans += n;
    }
    return ans;
  }
}
