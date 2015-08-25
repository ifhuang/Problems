package leetcode.algorithms;

// https://oj.leetcode.com/problems/string-to-integer-atoi/
public class StringtoInteger {
  public int myAtoi(String str) {
    char[] c = str.toCharArray();
    int n = c.length;
    int i = 0;
    while (i < n && c[i] == ' ')
      i++;
    int ans = 0;
    if (i == n)
      return ans;
    int sign = 1;
    if (c[i] == '+')
      i++;
    else if (c[i] == '-') {
      sign = -1;
      i++;
    }
    int bound1 = Integer.MAX_VALUE / 10;
    int bound2 = Integer.MAX_VALUE % 10;
    while (i < n) {
      if (c[i] >= '0' && c[i] <= '9') {
        int d = c[i] - '0';
        if (sign == 1 && (ans > bound1 || (ans == bound1 && d >= bound2)))
          return Integer.MAX_VALUE;
        else if (sign == -1 && (ans > bound1 || (ans == bound1 && d >= bound2 + 1)))
          return Integer.MIN_VALUE;
        ans *= 10;
        ans += d;
      } else
        break;
      i++;
    }
    return ans * sign;
  }
}
