package leetcode.algorithms;

import java.util.Arrays;
import java.util.Stack;

// https://oj.leetcode.com/problems/maximal-rectangle/
public class MaximalRectangle {
  public int maximalRectangle(char[][] matrix) {
    int m = matrix.length;
    if (m == 0)
      return 0;
    int n = matrix[0].length;
    int[] trans = new int[n];
    for (int j = 0; j < n; j++)
      trans[j] = matrix[0][j] - '0';
    int ans = largestRectangleArea(trans);
    for (int i = 1; i < m; i++) {
      for (int j = 0; j < n; j++)
        trans[j] = matrix[i][j] == '0' ? 0 : 1 + trans[j];
      ans = Math.max(ans, largestRectangleArea(trans));
    }
    return ans;
  }

  private int largestRectangleArea(int[] height) {
    Stack<Integer> stack = new Stack<>();
    int i = 0;
    int len = height.length + 1;
    int[] copy = new int[len];
    copy = Arrays.copyOf(height, len);
    int ans = 0;
    while (i < len) {
      if (stack.isEmpty() || copy[stack.peek()] <= copy[i])
        stack.push(i++);
      else {
        int t = stack.pop();
        int w = stack.isEmpty() ? i : i - stack.peek() - 1;
        ans = Math.max(ans, copy[t] * w);
      }
    }
    return ans;
  }
}
