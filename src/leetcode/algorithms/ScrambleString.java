package leetcode.algorithms;

// https://oj.leetcode.com/problems/scramble-string/
public class ScrambleString {
  public boolean isScramble(String s1, String s2) {
    if (s1.equals(s2))
      return true;
    int l1 = s1.length();
    int l2 = s2.length();
    if (l1 != l2)
      return false;
    int num = 128;
    int[] c1 = new int[num];
    for (int i = 0; i < l1; i++)
      c1[s1.charAt(i)]++;
    int[] c2 = new int[num];
    for (int i = 0; i < l2; i++)
      c2[s2.charAt(i)]++;
    for (int i = 0; i < num; i++)
      if (c1[i] != c2[i])
        return false;
    for (int i = 1; i < l1; i++)
      if ((isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i, l1),
          s2.substring(i, l2)))
          || (isScramble(s1.substring(0, i), s2.substring(l2 - i, l2)) && isScramble(
              s1.substring(i, l1), s2.substring(0, l2 - i))))
        return true;
    return false;
  }
}
