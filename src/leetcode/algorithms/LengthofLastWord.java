package leetcode.algorithms;

// https://oj.leetcode.com/problems/length-of-last-word/
public class LengthofLastWord {
  // time O(n), space O(1)
  public int lengthOfLastWord(String s) {
    int i = s.length() - 1;
    while (i >= 0 && s.charAt(i) == ' ') {
      i--;
    }
    int c = 0;
    while (i >= 0 && s.charAt(i) != ' ') {
      i--;
      c++;
    }
    return c;
  }
}
