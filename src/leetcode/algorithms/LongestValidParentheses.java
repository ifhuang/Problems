package leetcode.algorithms;

import java.util.Stack;

// https://oj.leetcode.com/problems/longest-valid-parentheses/
public class LongestValidParentheses {
  // time O(n), space O(n)
  public int longestValidParentheses(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    char[] c = s.toCharArray();
    int n = c.length;
    int[] dp = new int[n];
    int ans = 0;
    for (int i = n - 2; i >= 0; i--) {
      if (c[i] == '(') {
        int j = i + dp[i + 1] + 1;
        if (j < n && c[j] == ')') {
          dp[i] = dp[i + 1] + 2;
          if (j + 1 < n) {
            dp[i] += dp[j + 1];
          }
        }
      }
      ans = Math.max(ans, dp[i]);
    }
    return ans;
  }

  // time O(n), space O(n)
  public int longestValidParentheses2(String s) {
    Stack<Integer> stack = new Stack<>();
    char[] c = s.toCharArray();
    int n = c.length;
    for (int i = 0; i < n; i++) {
      if (c[i] == '(') {
        stack.push(i);
      } else {
        if (!stack.isEmpty() && c[stack.peek()] == '(') {
          stack.pop();
        } else {
          stack.push(i);
        }
      }
    }
    if (stack.isEmpty()) {
      return n;
    }
    int ans = 0;
    int pre = n;
    while (!stack.isEmpty()) {
      int cur = stack.pop();
      ans = Math.max(ans, pre - cur - 1);
      pre = cur;
    }
    ans = Math.max(ans, pre - 0);
    return ans;
  }
}
