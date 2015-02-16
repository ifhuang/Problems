package leetcode;

// https://oj.leetcode.com/problems/valid-palindrome/
public class ValidPalindrome {
  public boolean isPalindrome(String s) {
    int n = s.length();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      if (c >= 'a' && c <= 'z')
        sb.append(c);
      else if (c >= 'A' && c <= 'Z')
        sb.append((char) (c + ('a' - 'A')));
      else if (c >= '0' && c <= '9')
        sb.append(c);
    }
    return helper(sb.toString());
  }

  private boolean helper(String s) {
    int n = s.length();
    for (int i = 0, j = n - 1; i < j; i++, j--)
      if (s.charAt(i) != s.charAt(j))
        return false;
    return true;
  }
}
