package leetcode.algorithms;

// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
public class LongestIncreasingPathinaMatrix {
  public int longestIncreasingPath(int[][] matrix) {
    int ans = 0;
    int m = matrix.length;
    if (m == 0) {
      return ans;
    }
    int n = matrix[0].length;
    int[][] cache = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        ans = Math.max(ans, dfs(matrix, m, n, i, j, cache));
      }
    }
    return ans;
  }

  private int dfs(int[][] matrix, int m, int n, int x, int y, int[][] cache) {
    if (cache[x][y] > 0) {
      return cache[x][y];
    }
    int[][] d = { {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    cache[x][y] = 1;
    for (int i = 0; i < d.length; i++) {
      int nx = x + d[i][0];
      int ny = y + d[i][1];
      if (nx >= 0 && nx < m && ny >= 0 && ny < n && matrix[nx][ny] > matrix[x][y]) {
        cache[x][y] = Math.max(cache[x][y], 1 + dfs(matrix, m, n, nx, ny, cache));
      }
    }
    return cache[x][y];
  }
}
