package leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    if (n == 0)
      return new int[0];
    Deque<Integer> d = new ArrayDeque<>();
    int[] r = new int[n - k + 1];
    int ri = 0;
    for (int i = 0; i < n; i++) {
      if (!d.isEmpty() && d.peekFirst() == i - k)
        d.pollFirst();
      while (!d.isEmpty() && nums[d.peekLast()] < nums[i])
        d.pollLast();
      d.offerLast(i);
      if (i >= k - 1)
        r[ri++] = nums[d.peekFirst()];
    }
    return r;
  }
}
