package lintcode;

// http://www.lintcode.com/en/problem/strstr/
public class StrStr {
  /**
   * Returns a index to the first occurrence of target in source, or -1 if target is not part of
   * source.
   * 
   * @param source string to be scanned.
   * @param target string containing the sequence of characters to match.
   */
  public int strStr(String source, String target) {
    // write your code here
    if (source == null || target == null) {
      return -1;
    }
    int m = source.length();
    int n = target.length();
    for (int i = 0; i + n <= m; i++) {
      int j = 0;
      for (; j < n; j++) {
        if (source.charAt(i + j) != target.charAt(j)) {
          break;
        }
      }
      if (j == n) {
        return i;
      }
    }
    return -1;
  }
}
