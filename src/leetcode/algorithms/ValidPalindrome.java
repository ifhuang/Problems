package leetcode.algorithms;

// https://oj.leetcode.com/problems/valid-palindrome/
public class ValidPalindrome {
  public boolean isPalindrome(String s) {
    int n = s.length();
    int i = 0, j = n - 1;
    while (true) {
      while (i < n && !check(s.charAt(i))) {
        i++;
      }
      while (j >= 0 && !check(s.charAt(j))) {
        j--;
      }
      if (i == n || j == 0 || i >= j) {
        break;
      }
      if (!compare(s.charAt(i), s.charAt(j))) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  private boolean check(char c) {
    return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
  }

  private boolean compare(char a, char b) {
    if (a >= 'a' && a <= 'z') {
      a -= 'a' - 'A';
    }
    if (b >= 'a' && b <= 'z') {
      b -= 'a' - 'A';
    }
    return a == b;
  }
}
