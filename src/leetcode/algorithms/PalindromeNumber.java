package leetcode.algorithms;

// https://oj.leetcode.com/problems/palindrome-number/
public class PalindromeNumber {
  public boolean isPalindrome(int x) {
    if (x < 0)
      return false;
    int y = x;
    long t = 1;
    while (y > 0) {
      y /= 10;
      t *= 10;
    }
    int z = x;
    for (int i = 1, j = (int) (t / 10); i < j; i *= 10, j /= 10) {
      int a = z / i % 10;
      int b = z / j % 10;
      if (a != b)
        return false;
    }
    return true;
  }
}
