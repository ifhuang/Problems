package leetcode.algorithms;

// https://oj.leetcode.com/problems/implement-strstr/
public class ImplementstrStr {
  // time O(n*m), space O(1)
  public int strStr(String haystack, String needle) {
    char[] h = haystack.toCharArray();
    char[] n = needle.toCharArray();
    int a = 0, b = 0, c = 0;
    while (c + n.length - 1 < h.length) {
      while (b < n.length && h[a] == n[b]) {
        a++;
        b++;
      }
      if (b == n.length) {
        return c;
      } else {
        c++;
        a = c;
        b = 0;
      }
    }
    return -1;
  }
}
