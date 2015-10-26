package leetcode.algorithms;

// https://leetcode.com/problems/shortest-palindrome/
public class ShortestPalindrome {
  // time O(n), space O(n)
  public String shortestPalindrome(String s) {
    String r = (new StringBuilder(s)).reverse().toString();
    String t = s + "#" + r;
    int[] p = new int[t.length()];
    for (int i = 1; i < p.length; i++) {
      int j = p[i - 1];
      while (j > 0 && t.charAt(i) != t.charAt(j)) {
        j = p[j - 1];
      }
      p[i] = (j += t.charAt(i) == t.charAt(j) ? 1 : 0);
    }
    return r.substring(0, s.length() - p[p.length - 1]) + s;
  }
}
