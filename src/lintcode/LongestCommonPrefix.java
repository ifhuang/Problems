package lintcode;

// http://www.lintcode.com/en/problem/longest-common-prefix/
public class LongestCommonPrefix {
  /**
   * @param strs: A list of strings
   * @return: The longest common prefix
   */
  public String longestCommonPrefix(String[] strs) {
    // write your code here
    if (strs.length == 0) {
      return "";
    }
    int min = Integer.MAX_VALUE;
    for (String s : strs) {
      min = Math.min(min, s.length());
    }
    int i = 0;
    for (; i < min; i++) {
      int j = 1;
      for (; j < strs.length; j++) {
        if (strs[j].charAt(i) != strs[0].charAt(i)) {
          break;
        }
      }
      if (j < strs.length) {
        break;
      }
    }
    return strs[0].substring(0, i);
  }
}
