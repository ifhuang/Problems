package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

// https://oj.leetcode.com/problems/sudoku-solver/
public class SudokuSolver {
  public void solveSudoku(char[][] board) {
    int n = 9;
    Stack<State> stack = new Stack<>();
    char now = '0';
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        if (board[i][j] == '.') {
          now++;
          board[i][j] = now;
          while (!check(board, i, j)) {
            now++;
            if (now > '9')
              break;
            board[i][j] = now;
          }
          if (now > '9') {
            board[i][j] = '.';
            State s = stack.pop();
            board[s.x][s.y] = '.';
            while (s.n == '9') {
              s = stack.pop();
              board[s.x][s.y] = '.';
            }
            i = s.x;
            j = s.y - 1;
            now = s.n;
          } else {
            stack.push(new State(i, j, now));
            now = '0';
          }
        }
  }

  private boolean check(char[][] board, int r, int c) {
    int n = 9;
    Set<Character> set = new HashSet<>();
    for (int j = 0; j < n; j++)
      if (board[r][j] != '.')
        if (!set.add(board[r][j]))
          return false;
    set = new HashSet<>();
    for (int j = 0; j < n; j++)
      if (board[j][c] != '.')
        if (!set.add(board[j][c]))
          return false;
    set = new HashSet<>();
    for (int i = r / 3 * 3; i < r / 3 * 3 + 3; i++)
      for (int j = c / 3 * 3; j < c / 3 * 3 + 3; j++)
        if (board[i][j] != '.')
          if (!set.add(board[i][j]))
            return false;
    return true;
  }
}


class State {
  public int x;
  public int y;
  public char n;

  public State(int x, int y, char n) {
    this.x = x;
    this.y = y;
    this.n = n;
  }
}
