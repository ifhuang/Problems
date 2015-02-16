package leetcode;

// https://oj.leetcode.com/problems/palindrome-number/
public class PalindromeNumber {
  public boolean isPalindrome(int x) {
    if (x < 0)
      return false;
    else if (x < 10)
      return true;
    int n = 0;
    int tmp = x;
    while (tmp != 0) {
      tmp /= 10;
      n++;
    }
    int a = 0;
    int b = n;
    while (a < b) {
      int first = x / (int) Math.pow(10, b - 1) % 10;
      int last = x / (int) Math.pow(10, a) % 10;
      if (first != last)
        return false;
      a++;
      b--;
    }
    return true;
  }
}
