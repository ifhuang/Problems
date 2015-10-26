package leetcode.algorithms;

// https://oj.leetcode.com/problems/reverse-words-in-a-string/
public class ReverseWordsinaString {
  public String reverseWords(String s) {
    StringBuilder sb = new StringBuilder();
    int n = s.length();
    int start = -1;
    for (int i = 0; i <= n; i++) {
      if (i == n || s.charAt(i) == ' ') {
        if (start != -1) {
          sb.insert(0, s.substring(start, i));
          sb.insert(0, " ");
          start = -1;
        }
      } else if (start == -1) {
        start = i;
      }
    }
    if (sb.length() > 0) {
      sb.deleteCharAt(0);
    }
    return sb.toString();
  }
}
