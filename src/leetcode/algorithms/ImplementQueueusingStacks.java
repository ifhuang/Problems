package leetcode.algorithms;

import java.util.Stack;

// https://leetcode.com/problems/implement-queue-using-stacks/
public class ImplementQueueusingStacks {
  private Stack<Integer> in;
  private Stack<Integer> out;

  public ImplementQueueusingStacks() {
    in = new Stack<>();
    out = new Stack<>();
  }

  // Push element x to the back of queue.
  public void push(int x) {
    in.push(x);
  }

  // Removes the element from in front of queue.
  public void pop() {
    balance();
    out.pop();
  }

  // Get the front element.
  public int peek() {
    balance();
    return out.peek();
  }

  // Return whether the queue is empty.
  public boolean empty() {
    return in.isEmpty() && out.isEmpty();
  }

  private void balance() {
    if (out.isEmpty()) {
      while (!in.isEmpty()) {
        out.push(in.pop());
      }
    }
  }
}
