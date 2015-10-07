package leetcode.algorithms;

import java.util.Stack;

// https://oj.leetcode.com/problems/n-queens-ii/
public class NQueensII {
  class Queen {
    int x, y;
  }

  private int ans;

  // backtracking recursive
  public int totalNQueens(int n) {
    ans = 0;
    boolean[][] b = new boolean[n][n];
    backtracking(n, b, 0);
    return ans;
  }

  private void backtracking(int n, boolean[][] b, int row) {
    if (n == row) {
      ans++;
    } else {
      for (int i = 0; i < n; i++) {
        b[row][i] = true;
        if (check(n, b, row, i)) {
          backtracking(n, b, row + 1);
        }
        b[row][i] = false;
      }
    }
  }

  private boolean check(int n, boolean[][] b, int x, int y) {
    for (int i = 0; i < x; i++) {
      if (b[i][y]) {
        return false;
      }
    }
    for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
      if (b[i][j]) {
        return false;
      }
    }
    for (int i = x - 1, j = y + 1; i >= 0 && j < n; i--, j++) {
      if (b[i][j]) {
        return false;
      }
    }
    return true;
  }

  // backtracking iterative
  public int totalNQueens2(int n) {
    ans = 0;
    Stack<Queen> stack = new Stack<>();
    boolean[][] b = new boolean[n][n];
    int x = 0, y = 0;
    while (true) {
      if (x == n || y == n) {
        if (x == n) {
          ans++;
        }
        if (stack.isEmpty()) {
          break;
        }
        Queen q = stack.pop();
        b[q.x][q.y] = false;
        x = q.x;
        y = q.y + 1;
      } else {
        if (check(n, b, x, y)) {
          b[x][y] = true;
          Queen q = new Queen();
          q.x = x;
          q.y = y;
          stack.push(q);
          x++;
          y = 0;
        } else {
          y++;
        }
      }
    }
    return ans;
  }
}
