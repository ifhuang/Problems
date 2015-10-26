package lintcode;

public class TwoStringsAreAnagrams {
  /**
   * @param s: The first string
   * @param b: The second string
   * @return true or false
   */
  public boolean anagram(String s, String t) {
    // write your code here
    int m = s.length();
    if (m != t.length()) {
      return false;
    }
    int len = 256;
    int[] c = new int[len];
    for (int i = 0; i < m; i++) {
      c[s.charAt(i)]++;
      c[t.charAt(i)]--;
    }
    for (int i = 0; i < len; i++) {
      if (c[i] != 0) {
        return false;
      }
    }
    return true;
  }
}
