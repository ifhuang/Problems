package leetcode.algorithms;

import java.util.Stack;

// https://oj.leetcode.com/problems/valid-parentheses/
public class ValidParentheses {
  // time O(n), space O(n)
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        char pre = stack.pop();
        if ((pre == '(' && c == ')') || (pre == '{' && c == '}') || (pre == '[' && c == ']'))
          continue;
        else {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}
