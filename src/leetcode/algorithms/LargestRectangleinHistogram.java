package leetcode.algorithms;

import java.util.Arrays;
import java.util.Stack;

// https://oj.leetcode.com/problems/largest-rectangle-in-histogram/
public class LargestRectangleinHistogram {
  // time O(n), space O(n)
  public int largestRectangleArea(int[] height) {
    int n = height.length;
    int[] h = Arrays.copyOf(height, n + 1);
    Stack<Integer> stack = new Stack<>();
    int ans = 0;
    for (int i = 0; i < h.length;) {
      if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
        stack.push(i++);
      } else {
        int j = stack.pop();
        int w = stack.isEmpty() ? i : i - stack.peek() - 1;
        ans = Math.max(ans, w * h[j]);
      }
    }
    return ans;
  }
}
