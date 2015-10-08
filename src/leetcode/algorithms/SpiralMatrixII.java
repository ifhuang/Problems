package leetcode.algorithms;

// https://oj.leetcode.com/problems/spiral-matrix-ii/
public class SpiralMatrixII {
  public int[][] generateMatrix(int n) {
    int[][] m = new int[n][n];
    int[][] d = { {0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int s = 0, x = 0, y = 0, c = 0;
    while (c++ < n * n) {
      m[x][y] = c;
      if (!check(m, n, d, s, x, y)) {
        s = (s + 1) % 4;
      }
      x += d[s][0];
      y += d[s][1];
    }
    return m;
  }

  private boolean check(int[][] m, int n, int[][] d, int s, int x, int y) {
    x += d[s][0];
    y += d[s][1];
    return x >= 0 && x < n && y >= 0 && y < n && m[x][y] == 0;
  }

  public int[][] generateMatrix2(int n) {
    int left = 0, right = n - 1, up = 0, down = n - 1;
    int[][] m = new int[n][n];
    int c = 1;
    while (c <= n * n) {
      for (int i = left; i <= right; i++) {
        m[up][i] = c++;
      }
      up++;
      for (int i = up; i <= down; i++) {
        m[i][right] = c++;
      }
      right--;
      if (c > n * n) {
        break;
      }
      for (int i = right; i >= left; i--) {
        m[down][i] = c++;
      }
      down--;
      for (int i = down; i >= up; i--) {
        m[i][left] = c++;
      }
      left++;
    }
    return m;
  }
}
