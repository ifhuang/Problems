package leetcode.algorithms;

// https://leetcode.com/problems/one-edit-distance/
// Given two strings S and T, determine if they are both one edit distance apart.
public class OneEditDistance {
  public boolean isOneEditDistance(String s, String t) {
    int ns = s.length();
    int nt = t.length();
    if (ns < nt) {
      return isOneEditDistance(t, s);
    } else if (ns - nt > 1) {
      return false;
    } else if (ns - nt == 1) {
      return isDel(s, t);
    } else {
      return isMod(s, t);
    }
  }

  private boolean isDel(String s, String t) {
    for (int i = 0, j = 0; i < s.length() && j < t.length(); i++, j++) {
      if (s.charAt(i) != t.charAt(j)) {
        return s.substring(i + 1).equals(t.substring(j));
      }
    }
    return true;
  }

  private boolean isMod(String s, String t) {
    int diff = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != t.charAt(i)) {
        diff++;
      }
    }
    return diff == 1;
  }
}
