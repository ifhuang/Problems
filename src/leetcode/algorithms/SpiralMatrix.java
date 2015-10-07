package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

// https://oj.leetcode.com/problems/spiral-matrix/
public class SpiralMatrix {
  // time O(n^2), space O(1)
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> ans = new ArrayList<>();
    if (matrix.length == 0) {
      return ans;
    }
    int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
    while (left <= right && up <= down) {
      for (int i = left; i <= right; i++) {
        ans.add(matrix[up][i]);
      }
      up++;
      for (int i = up; i <= down; i++) {
        ans.add(matrix[i][right]);
      }
      right--;
      if (left > right || up > down) {
        break;
      }
      for (int i = right; i >= left; i--) {
        ans.add(matrix[down][i]);
      }
      down--;
      for (int i = down; i >= up; i--) {
        ans.add(matrix[i][left]);
      }
      left++;
    }
    return ans;
  }

  // time O(n^2), space O(1)
  public List<Integer> spiralOrder2(int[][] matrix) {
    List<Integer> ans = new ArrayList<>();
    int m = matrix.length;
    if (m == 0) {
      return ans;
    }
    int n = matrix[0].length;
    int[] bound = {0, m - 1, 0, n - 1};
    int s = 0;
    int[][] d = { {0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int c = 0, x = 0, y = 0;
    while (true) {
      ans.add(matrix[x][y]);
      c++;
      if (c == m * n) {
        break;
      }
      if (!check(bound, x, y, d, s)) {
        switch (s) {
          case 0:
            bound[0]++;
            break;
          case 1:
            bound[3]--;
            break;
          case 2:
            bound[1]--;
            break;
          case 3:
            bound[2]++;
            break;
        }
        s = (s + 1) % 4;
      }
      x += d[s][0];
      y += d[s][1];
    }
    return ans;
  }

  private boolean check(int[] bound, int x, int y, int[][] d, int s) {
    x += d[s][0];
    y += d[s][1];
    return x >= bound[0] && x <= bound[1] && y >= bound[2] && y <= bound[3];
  }
}
