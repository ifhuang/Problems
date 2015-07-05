package leetcode.algorithms;

import java.util.Stack;

public class BasicCalculatorII {
  public int calculate(String s) {
    int num = 0;
    char sign = '+';
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c))
        num = num * 10 + c - '0';
      if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
        if (sign == '+')
          stack.push(num);
        else if (sign == '-')
          stack.push(-num);
        else if (sign == '*')
          stack.push(stack.pop() * num);
        else if (sign == '/')
          stack.push(stack.pop() / num);
        num = 0;
        sign = c;
      }
    }
    int ans = 0;
    while (!stack.isEmpty())
      ans += stack.pop();
    return ans;
  }
}
