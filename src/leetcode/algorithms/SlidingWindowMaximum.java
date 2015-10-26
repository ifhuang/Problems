package leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/sliding-window-maximum/
public class SlidingWindowMaximum {
  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    if (n == 0) {
      return new int[] {};
    }
    Deque<Integer> deque = new ArrayDeque<>();
    int[] ans = new int[n - k + 1];
    int index = 0;
    for (int i = 0; i < n; i++) {
      if (!deque.isEmpty() && deque.peekFirst() == i - k){
        deque.pollFirst();
      }
      while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
        deque.pollLast();
      }
      deque.offerLast(i);
      if (i >= k - 1){
        ans[index++] = nums[deque.peekFirst()];
      }
    }
    return ans;
  }

  public int[] maxSlidingWindow2(int[] nums, int k) {
    int n = nums.length;
    if (n == 0) {
      return new int[] {};
    }
    int[] max_left = new int[n];
    int[] max_right = new int[n];
    max_left[0] = nums[0];
    max_right[n - 1] = nums[n - 1];
    for (int i = 1; i < n; i++) {
      max_left[i] = (i % k == 0) ? nums[i] : Math.max(max_left[i - 1], nums[i]);
      int j = n - i - 1;
      max_right[j] = (j % k == 0) ? nums[j] : Math.max(max_right[j + 1], nums[j]);
    }
    int[] ans = new int[n - k + 1];
    for (int i = 0; i + k <= n; i++) {
      ans[i] = Math.max(max_right[i], max_left[i + k - 1]);
    }
    return ans;
  }
}
