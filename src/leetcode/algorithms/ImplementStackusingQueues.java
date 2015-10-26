package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/implement-stack-using-queues/
public class ImplementStackusingQueues {
  private Queue<Integer> queue;

  public ImplementStackusingQueues() {
    queue = new LinkedList<>();
  }

  // Push element x onto stack.
  public void push(int x) {
    queue.offer(x);
    int n = queue.size();
    for (int i = 0; i < n - 1; i++) {
      queue.offer(queue.poll());
    }
  }

  // Removes the element on top of the stack.
  public void pop() {
    queue.poll();
  }

  // Get the top element.
  public int top() {
    return queue.peek();
  }

  // Return whether the stack is empty.
  public boolean empty() {
    return queue.isEmpty();
  }
}
