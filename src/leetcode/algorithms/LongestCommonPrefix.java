package leetcode.algorithms;

// https://oj.leetcode.com/problems/longest-common-prefix/
public class LongestCommonPrefix {
  // recursive
  public String longestCommonPrefix(String[] strs) {
    int n = strs.length;
    if (n == 0)
      return "";
    for (int i = 0; i < n; i++)
      if (strs[i].length() == 0 || strs[i].charAt(0) != strs[0].charAt(0))
        return "";
    char c = strs[0].charAt(0);
    for (int i = 0; i < n; i++)
      strs[i] = strs[i].substring(1);
    return c + longestCommonPrefix(strs);
  }

  // iterative
  public String longestCommonPrefix2(String[] strs) {
    StringBuilder ans = new StringBuilder();
    if (strs.length > 0) {
      for (int i = 0; i < strs[0].length(); i++) {
        char c = strs[0].charAt(i);
        for (int j = 1; j < strs.length; j++) {
          if (strs[j].length() - 1 < i || strs[j].charAt(i) != c)
            return ans.toString();
        }
        ans.append(c);
      }
    }
    return ans.toString();
  }
}
