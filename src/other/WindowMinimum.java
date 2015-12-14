package other;

import java.util.Deque;
import java.util.LinkedList;

public class WindowMinimum {
  public int[] solve(int[] nums, int k) {
    int n = nums.length;
    if (n == 0) {
      return new int[] {};
    }
    int[] ans = new int[n - k + 1];
    int index = 0;
    Deque<Integer> deque = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (!deque.isEmpty() && deque.peekFirst() == i - k) {
        deque.pollFirst();
      }
      while (!deque.isEmpty() && nums[deque.peekLast()] > nums[i]) {
        deque.pollLast();
      }
      deque.offerLast(i);
      if (i - k + 1 >= 0) {
        ans[index++] = nums[deque.peekFirst()];
      }
    }
    return ans;
  }
}
