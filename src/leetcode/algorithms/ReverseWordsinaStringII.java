package leetcode.algorithms;

// https://leetcode.com/problems/reverse-words-in-a-string-ii/
// Given an input string, reverse the string word by word. A word is defined as a sequence of
// non-space characters.
// The input string does not contain leading or trailing spaces and the words are always separated
// by a single space.
// For example,
// Given s = "the sky is blue",
// return "blue is sky the".
// Could you do it in-place without allocating extra space?
// Related problem: Rotate Array
public class ReverseWordsinaStringII {
  public void reverseWords(char[] s) {
    int n = s.length;
    reverse(s, 0, n - 1);
    int i = 0;
    for (int j = 1; j < n; j++) {
      if (s[j] == ' ') {
        reverse(s, i, j - 1);
        i = j + 1;
      }
    }
    reverse(s, i, n - 1);
  }

  private void reverse(char[] c, int i, int j) {
    while (i < j) {
      char t = c[i];
      c[i] = c[j];
      c[j] = t;
      i++;
      j--;
    }
  }
}
