package leetcode;

import java.util.Stack;

// https://oj.leetcode.com/problems/evaluate-reverse-polish-notation/
public class EvaluateReversePolishNotation {
  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    for (String t : tokens)
      if (t.equals("+"))
        stack.push(stack.pop() + stack.pop());
      else if (t.equals("-")) {
        int b = stack.pop();
        int a = stack.pop();
        stack.push(a - b);
      } else if (t.equals("*"))
        stack.push(stack.pop() * stack.pop());
      else if (t.equals("/")) {
        int b = stack.pop();
        int a = stack.pop();
        stack.push(a / b);
      } else
        stack.push(Integer.parseInt(t));
    return stack.pop();
  }
}
