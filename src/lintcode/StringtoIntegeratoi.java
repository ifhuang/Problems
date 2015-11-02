package lintcode;

// http://www.lintcode.com/en/problem/string-to-integeratoi/
public class StringtoIntegeratoi {
  /**
   * @param str: A string
   * @return An integer
   */
  public int atoi(String str) {
    // write your code here
    int i = 0;
    int len = str.length();
    if (i == len) {
      return 0;
    }
    while (str.charAt(i) == ' ') {
      i++;
    }
    int sign = 1;
    if (str.charAt(i) == '+') {
      sign = 1;
      i++;
    } else if (str.charAt(i) == '-') {
      sign = -1;
      i++;
    }
    long ans = 0;
    while (i < len && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
      int d = str.charAt(i) - '0';
      ans = ans * 10 + d;
      if (sign == 1 && ans > Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
      } else if (sign == -1 && -1 * ans < Integer.MIN_VALUE) {
        return Integer.MIN_VALUE;
      }
      i++;
    }
    return (int) (sign * ans);
  }
}
