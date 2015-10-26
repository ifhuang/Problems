package other;

import java.util.Stack;

public class MinQueue {
  private MinStack in;
  private MinStack out;

  public MinQueue() {
    in = new MinStack();
    out = new MinStack();
  }

  public void offer(int x) {
    in.push(x);
  }

  public void poll() {
    if (out.size() == 0) {
      balance();
    }
    out.pop();
  }

  public int peek() {
    if (out.size() == 0) {
      balance();
    }
    return out.top();
  }

  public int getMin() {
    return Math.min(in.getMin(), out.getMin());
  }

  private void balance() {
    while (in.size() > 0) {
      out.push(in.pop());
    }
  }
}


class MinStack {
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

  public int pop() {
    int x = data.pop();
    if (x == min.peek()) {
      min.pop();
    }
    return x;
  }

  public int top() {
    return data.peek();
  }

  public int getMin() {
    return min.peek();
  }

  public int size() {
    return data.size();
  }
}
