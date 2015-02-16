package leetcode;

import java.util.Arrays;
import java.util.Stack;

// https://oj.leetcode.com/problems/largest-rectangle-in-histogram/
public class LargestRectangleinHistogram {
  public int largestRectangleArea(int[] height) {
    Stack<Integer> stack = new Stack<>();
    int i = 0;
    int len = height.length + 1;
    int[] copy = new int[len];
    copy = Arrays.copyOf(height, len);
    int ans = 0;
    while (i < len)
      if (stack.isEmpty() || copy[stack.peek()] <= copy[i])
        stack.push(i++);
      else {
        int t = stack.pop();
        int w = stack.isEmpty() ? i : i - stack.peek() - 1;
        ans = Math.max(ans, copy[t] * w);
      }
    return ans;
  }
}
