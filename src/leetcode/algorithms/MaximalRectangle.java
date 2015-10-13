package leetcode.algorithms;

import java.util.Arrays;
import java.util.Stack;

// https://oj.leetcode.com/problems/maximal-rectangle/
public class MaximalRectangle {
  // time O(n^2), space O(n)
  public int maximalRectangle(char[][] matrix) {
    int m = matrix.length;
    if (m == 0) {
      return 0;
    }
    int n = matrix[0].length;
    int[] c = new int[n];
    for (int i = 0; i < n; i++) {
      if (matrix[0][i] == '1') {
        c[i] = 1;
      }
    }
    int ans = largestRectangleArea(c);
    for (int i = 1; i < m; i++) {
      for (int j = 0; j < n; j++) {
        c[j] = matrix[i][j] == '1' ? c[j] + 1 : 0;
      }
      ans = Math.max(ans, largestRectangleArea(c));
    }
    return ans;
  }

  private int largestRectangleArea(int[] height) {
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
