package leetcode;

// https://oj.leetcode.com/problems/longest-common-prefix/
public class LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0 || strs[0].length() == 0)
      return "";
    char c = strs[0].charAt(0);
    strs[0] = strs[0].substring(1);
    for (int i = 1; i < strs.length; i++) {
      if (strs[i].length() == 0 || strs[i].charAt(0) != c)
        return "";
      strs[i] = strs[i].substring(1);
    }
    return c + longestCommonPrefix(strs);
  }
}
