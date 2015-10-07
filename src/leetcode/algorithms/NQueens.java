package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://oj.leetcode.com/problems/n-queens/
public class NQueens {
  class Queen {
    int x, y;
  }

  // backtracking recursive
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> ans = new ArrayList<>();
    boolean[][] b = new boolean[n][n];
    backtracking(n, b, 0, ans);
    return ans;
  }

  private void backtracking(int n, boolean[][] b, int row, List<List<String>> ans) {
    if (n == row) {
      ans.add(makeBoard(n, b));
    } else {
      for (int i = 0; i < n; i++) {
        b[row][i] = true;
        if (check(n, b, row, i)) {
          backtracking(n, b, row + 1, ans);
        }
        b[row][i] = false;
      }
    }
  }

  private List<String> makeBoard(int n, boolean[][] b) {
    List<String> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < n; j++) {
        sb.append(b[i][j] ? "Q" : ".");
      }
      list.add(sb.toString());
    }
    return list;
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
  public List<List<String>> solveNQueens2(int n) {
    Stack<Queen> stack = new Stack<>();
    boolean[][] b = new boolean[n][n];
    List<List<String>> ans = new ArrayList<>();
    int x = 0, y = 0;
    while (true) {
      if (x == n || y == n) {
        if (x == n) {
          ans.add(makeBoard(n, b));
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
