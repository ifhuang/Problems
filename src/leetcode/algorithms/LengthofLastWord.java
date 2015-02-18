package leetcode.algorithms;

// https://oj.leetcode.com/problems/length-of-last-word/
public class LengthofLastWord {
  public int lengthOfLastWord(String s) {
    int i = s.length() - 1;
    for (; i >= 0 && s.charAt(i) == ' '; i--);
    if (i < 0)
      return 0;
    int len = 0;
    for (; i >= 0 && s.charAt(i) != ' '; i--, len++);
    return len;
  }
}
