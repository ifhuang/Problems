package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues {
  private Queue<Integer> q1 = new LinkedList<>();
  private Queue<Integer> q2 = new LinkedList<>();

  // Push element x onto stack.
  public void push(int x) {
    q1.offer(x);
  }

  // Removes the element on top of the stack.
  public void pop() {
    helper();
    q1.poll();
  }

  // Get the top element.
  public int top() {
    helper();
    return q1.peek();
  }

  // Return whether the stack is empty.
  public boolean empty() {
    return q1.isEmpty() && q2.isEmpty();
  }

  private void helper() {
    if (q1.isEmpty())
      while (!q2.isEmpty())
        q1.offer(q2.poll());
    while (q1.size() > 1)
      q2.offer(q1.poll());
  }
}
