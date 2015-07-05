package leetcode.algorithms;

import java.util.Stack;

public class BasicCalculator {
  public int calculate(String s) {
    int num = 0, sign = 1, ans = 0;
    Stack<Integer> stack = new Stack<>();
    for (char c : s.toCharArray())
      if (c >= '0' && c <= '9')
        num = num * 10 + c - '0';
      else if (c == '+') {
        ans += sign * num;
        num = 0;
        sign = 1;
      } else if (c == '-') {
        ans += sign * num;
        num = 0;
        sign = -1;
      } else if (c == '(') {
        stack.push(ans);
        stack.push(sign);
        ans = 0;
        sign = 1;
      } else if (c == ')') {
        ans += sign * num;
        num = 0;
        ans *= stack.pop();
        ans += stack.pop();
      }
    ans += sign * num;
    return ans;
  }
}
