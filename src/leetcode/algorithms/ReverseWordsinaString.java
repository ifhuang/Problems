package leetcode.algorithms;

import java.util.Stack;

// https://oj.leetcode.com/problems/reverse-words-in-a-string/
public class ReverseWordsinaString {
  public String reverseWords(String s) {
    Stack<String> stack = new Stack<>();
    int n = s.length();
    int start = -1;
    for (int i = 0; i <= n; i++)
      if (i == n || s.charAt(i) == ' ') {
        if (start != -1) {
          stack.push(s.substring(start, i));
          start = -1;
        }
      } else {
        if (start == -1)
          start = i;
      }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop()).append(" ");
    }
    int newN = sb.length();
    if (newN > 0)
      sb.deleteCharAt(newN - 1);
    return sb.toString();
  }
}
