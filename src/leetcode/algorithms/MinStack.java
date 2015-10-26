package leetcode.algorithms;

import java.util.Stack;

// https://oj.leetcode.com/problems/min-stack/
public class MinStack {
  private Stack<Integer> data;
  private Stack<Integer> min;

  public MinStack() {
    data = new Stack<>();
    min = new Stack<>();
  }

  public void push(int x) {
    data.push(x);
    if (min.isEmpty() || x <= min.peek()) {
      min.push(x);
    }
  }

  public void pop() {
    int x = data.pop();
    if (x == min.peek()) {
      min.pop();
    }
  }

  public int top() {
    return data.peek();
  }

  public int getMin() {
    return min.peek();
  }
}
