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

  class UF {
    private int[] parent;
    private byte[] rank;
    private int count;

    public UF(int n) {
      parent = new int[n];
      rank = new byte[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
        rank[i] = 0;
      }
      count = n;
    }

    public boolean connected(int p, int q) {
      return find(p) == find(q);
    }

    public int count() {
      return count;
    }

    public int find(int p) {
      while (p != parent[p]) {
        parent[p] = parent[parent[p]];
        p = parent[p];
      }
      return p;
    }

    public void union(int p, int q) {
      int pId = find(p);
      int qId = find(q);
      if (pId == qId) {
        return;
      }
      if (rank[pId] > rank[qId]) {
        parent[qId] = pId;
      } else if (rank[pId] < rank[qId]) {
        parent[pId] = qId;
      } else {
        parent[qId] = pId;
        rank[pId]++;
      }
      count--;
    }
  }

  public int numIslands2(char[][] grid) {
    int m = grid.length;
    if (m == 0) {
      return 0;
    }
    int n = grid[0].length;
    int[][] d = { {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    UF uf = new UF(m * n);
    int ones = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          ones++;
          int index = i * n + j;
          for (int k = 0; k < d.length; k++) {
            int x = i + d[k][0];
            int y = j + d[k][1];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
              int z = x * n + y;
              uf.union(index, z);
            }
          }
        }
      }
    }
    return ones - (m * n - uf.count());
  }
}
