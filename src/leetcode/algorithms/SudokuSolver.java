package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

// https://oj.leetcode.com/problems/sudoku-solver/
public class SudokuSolver {
  // backtracking
  public void solveSudoku(char[][] board) {
    int n = board.length;
    int m = board[0].length;
    Stack<State> stack = new Stack<>();
    char pre = '0';
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == '.') {
          char c = (char) (pre + 1);
          for (; c <= '9'; c++) {
            board[i][j] = c;
            if (isValid(board, i, j)) {
              stack.push(new State(i, j, c));
              pre = '0';
              break;
            }
          }
          if (c > '9') {
            board[i][j] = '.';
            State state = stack.pop();
            i = state.x;
            j = state.y;
            board[i][j] = '.';
            pre = state.c;
            j--;
          }
        }
      }
    }
  }

  private boolean isValid(char[][] board, int x, int y) {
    int n = board.length;
    int m = board[0].length;
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      if (board[i][y] != '.') {
        if (!set.add(board[i][y])) {
          return false;
        }
      }
    }
    set = new HashSet<>();
    for (int j = 0; j < m; j++) {
      if (board[x][j] != '.') {
        if (!set.add(board[x][j])) {
          return false;
        }
      }
    }
    set = new HashSet<>();
    int a = x / 3;
    int b = y / 3;
    for (int i = a * 3; i < a * 3 + 3; i++) {
      for (int j = b * 3; j < b * 3 + 3; j++) {
        if (board[i][j] != '.') {
          if (!set.add(board[i][j])) {
            return false;
          }
        }
      }
    }
    return true;
  }

  // recursion
  public void solveSudoku2(char[][] board) {
    dfs(board, 0, 0);
  }

  private boolean dfs(char[][] board, int x, int y) {
    int n = board.length;
    int m = board[0].length;
    if (x == n) {
      return true;
    } else if (y == m) {
      return dfs(board, x + 1, 0);
    } else if (board[x][y] != '.') {
      return dfs(board, x, y + 1);
    } else {
      for (char c = '1'; c <= '9'; c++) {
        board[x][y] = c;
        if (isValid(board, x, y) && dfs(board, x, y + 1)) {
          return true;
        }
        board[x][y] = '.';
      }
      return false;
    }
  }
}


class State {
  int x, y;
  char c;

  State(int x, int y, char c) {
    this.x = x;
    this.y = y;
    this.c = c;
  }
}
