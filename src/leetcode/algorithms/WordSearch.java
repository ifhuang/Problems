package leetcode.algorithms;

import java.util.Stack;

// https://oj.leetcode.com/problems/word-search/
public class WordSearch {
  // backtracking with dfs
  public boolean exist(char[][] board, String word) {
    int m = board.length;
    if (m == 0) {
      return false;
    }
    int n = board[0].length;
    boolean[][] b = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (backtracking(board, word, m, n, i, j, 0, b)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean backtracking(char[][] board, String word, int m, int n, int x, int y, int i,
      boolean[][] b) {
    if (i == word.length()) {
      return true;
    } else if (x < 0 || x >= m || y < 0 || y >= n || b[x][y] || board[x][y] != word.charAt(i)) {
      return false;
    }
    b[x][y] = true;
    int[][] d = { {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    for (int j = 0; j < d.length; j++) {
      if (backtracking(board, word, m, n, x + d[j][0], y + d[j][1], i + 1, b)) {
        return true;
      }
    }
    b[x][y] = false;
    return false;
  }

  class State {
    int x;
    int y;
    int s;

    State(int x, int y, int s) {
      this.x = x;
      this.y = y;
      this.s = s;
    }
  }

  // backtracking with non-dfs
  public boolean exist2(char[][] board, String word) {
    int m = board.length;
    int n = board[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (search(board, word, i, j)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean search(char[][] board, String word, int x, int y) {
    if (board[x][y] != word.charAt(0)) {
      return false;
    }
    int[][] d = { {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    Stack<State> stack = new Stack<>();
    int index = 1;
    int len = word.length();
    int s = 0;
    while (true) {
      if (index == len) {
        return true;
      }
      while (s < 4 && !check(board, word, x + d[s][0], y + d[s][1], stack, index)) {
        s++;
      }
      if (s == 4) {
        if (stack.isEmpty()) {
          return false;
        } else {
          State state = stack.pop();
          x = state.x;
          y = state.y;
          s = state.s + 1;
          index--;
        }
      } else {
        stack.push(new State(x, y, s));
        x = x + d[s][0];
        y = y + d[s][1];
        s = 0;
        index++;
      }
    }
  }

  private boolean check(char[][] board, String word, int x, int y, Stack<State> stack, int index) {
    int m = board.length;
    int n = board[0].length;
    if (x < 0 || x >= m || y < 0 || y >= n) {
      return false;
    }
    for (State s : stack) {
      if (s.x == x && s.y == y) {
        return false;
      }
    }
    return board[x][y] == word.charAt(index);
  }
}
