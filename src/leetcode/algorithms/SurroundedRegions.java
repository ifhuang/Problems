package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// https://oj.leetcode.com/problems/surrounded-regions/
public class SurroundedRegions {
  class Pair {
    int x;
    int y;

    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public void solve(char[][] board) {
    int m = board.length;
    if (m < 2)
      return;
    int n = board[0].length;
    if (n < 2)
      return;
    int[][] d = { {0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int s = 0, x = 0, y = 0;
    while (true) {
      if (check(m, n, d, s, x, y))
        s++;
      if (s == 4)
        break;
      x += d[s][0];
      y += d[s][1];
      search(board, m, n, d, x, y);
    }
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        if (board[i][j] == '.')
          board[i][j] = 'O';
        else if (board[i][j] == 'O')
          board[i][j] = 'X';
  }

  private boolean check(int m, int n, int[][] d, int s, int x, int y) {
    x += d[s][0];
    y += d[s][1];
    return x < 0 || x >= m || y < 0 || y >= n;
  }

  private void search(char[][] board, int m, int n, int[][] d, int x, int y) {
    if (board[x][y] == 'O') {
      Stack<Pair> stack = new Stack<>();
      stack.push(new Pair(x, y));
      while (!stack.isEmpty()) {
        Pair p = stack.pop();
        board[p.x][p.y] = '.';
        for (int i = 0; i < 4; i++)
          if (!check(m, n, d, i, p.x, p.y) && board[p.x + d[i][0]][p.y + d[i][1]] == 'O')
            stack.push(new Pair(p.x + d[i][0], p.y + d[i][1]));
      }
    }
  }

  public void solve2(char[][] board) {
    int m = board.length;
    if (m == 0) {
      return;
    }
    int n = board[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
          bfs(board, m, n, i, j);
        }
      }
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = board[i][j] == '.' ? 'O' : 'X';
      }
    }
  }

  private void bfs(char[][] board, int m, int n, int x, int y) {
    Queue<Pair> queue = new LinkedList<>();
    board[x][y] = '.';
    queue.offer(new Pair(x, y));
    int[][] d = { {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    while (!queue.isEmpty()) {
      Pair p = queue.poll();
      for (int i = 0; i < d.length; i++) {
        int nx = p.x + d[i][0];
        int ny = p.y + d[i][1];
        if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 'O') {
          board[nx][ny] = '.';
          queue.offer(new Pair(nx, ny));
        }
      }
    }
  }
}
