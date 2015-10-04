package leetcode.algorithms;

// https://oj.leetcode.com/problems/wildcard-matching/
public class WildcardMatching {
  // time O(ns*np), space O(ns*np)
  public boolean isMatch(String s, String p) {
    int ns = s.length();
    int np = p.length();
    boolean[][] dp = new boolean[ns + 1][np + 1];
    dp[0][0] = true;
    for (int j = 1; j < np + 1; j++) {
      dp[0][j] = dp[0][j - 1] && p.charAt(j - 1) == '*';
    }
    for (int i = 1; i < ns + 1; i++) {
      for (int j = 1; j < np + 1; j++) {
        char cs = s.charAt(i - 1);
        char cp = p.charAt(j - 1);
        if (cs == cp || cp == '?') {
          dp[i][j] = dp[i - 1][j - 1];
        } else if (cp == '*') {
          dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i - 1][j - 1];
        }
      }
    }
    return dp[ns][np];
  }

  // time O(ns + np), space O(1)
  public boolean isMatch2(String s, String p) {
    int sIndex = 0, pIndex = 0, match = 0, starIndex = -1;
    while (sIndex < s.length())
      if (pIndex < p.length() && (p.charAt(pIndex) == '?' || s.charAt(sIndex) == p.charAt(pIndex))) {
        sIndex++;
        pIndex++;
      } else if (pIndex < p.length() && p.charAt(pIndex) == '*') {
        starIndex = pIndex;
        match = sIndex;
        pIndex++;
      } else if (starIndex != -1) {
        pIndex = starIndex + 1;
        match++;
        sIndex = match;
      } else
        return false;
    while (pIndex < p.length() && p.charAt(pIndex) == '*')
      pIndex++;
    return pIndex == p.length();
  }
}
