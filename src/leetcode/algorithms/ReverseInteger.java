package leetcode.algorithms;

// https://oj.leetcode.com/problems/reverse-integer/
public class ReverseInteger {
  public int reverse(int x) {
    if (x == Integer.MIN_VALUE)
      return 0;
    int sign = x >= 0 ? 1 : -1;
    int y = Math.abs(x);
    int bound1 = Integer.MAX_VALUE / 10;
    int bound2 = Integer.MAX_VALUE % 10;
    int ans = 0;
    while (y > 0) {
      int i = y % 10;
      if (ans > bound1 || (ans == bound1 && y > bound2))
        return 0;
      ans *= 10;
      ans += i;
      y /= 10;
    }
    return ans * sign;
  }
}
