package leetcode.algorithms;

import java.util.Arrays;

// https://leetcode.com/problems/valid-anagram/
public class ValidAnagram {
  public boolean isAnagram(String s, String t) {
    char[] sc = s.toCharArray();
    char[] tc = t.toCharArray();
    Arrays.sort(sc);
    Arrays.sort(tc);
    return (new String(sc)).equals(new String(tc));
  }

  public boolean isAnagram2(String s, String t) {
    int m = s.length();
    if (m != t.length()) {
      return false;
    }
    int len = 26;
    int[] c = new int[len];
    for (int i = 0; i < m; i++) {
      c[s.charAt(i) - 'a']++;
      c[t.charAt(i) - 'a']--;
    }
    for (int i = 0; i < len; i++) {
      if (c[i] != 0) {
        return false;
      }
    }
    return true;
  }
}
