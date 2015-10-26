package leetcode.algorithms;

// https://leetcode.com/problems/number-of-islands/
public class NumberofIslands {

  private int count = 0;
  private int n = 0;
  private int m = 0;
  private int[][] d = { {1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public int numIslands(char[][] grid) {
    n = grid.length;
    if (n == 0) {
      return count;
    }
    m = grid[0].length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == '1') {
          count++;
          dfs(grid, i, j);
        }
      }
    }
    return count;
  }

  private void dfs(char[][] grid, int i, int j) {
    grid[i][j] = '0';
    for (int k = 0; k < d.length; k++) {
      int x = i + d[k][0];
      int y = j + d[k][1];
      if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == '1') {
        dfs(grid, x, y);
      }
    }
  }

}
