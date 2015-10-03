package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

// https://oj.leetcode.com/problems/valid-sudoku/
public class ValidSudoku {
  // time o(n*m), space O(1)
  public boolean isValidSudoku(char[][] board) {
    int n = board.length;
    int m = board[0].length;
    for (int i = 0; i < n; i++) {
      Set<Character> set = new HashSet<>();
      for (int j = 0; j < m; j++) {
        if (board[i][j] != '.') {
          if (!set.add(board[i][j])) {
            return false;
          }
        }
      }
    }
    for (int j = 0; j < m; j++) {
      Set<Character> set = new HashSet<>();
      for (int i = 0; i < n; i++) {
        if (board[i][j] != '.') {
          if (!set.add(board[i][j])) {
            return false;
          }
        }
      }
    }
    for (int x = 0; x < n / 3; x++) {
      for (int y = 0; y < m / 3; y++) {
        Set<Character> set = new HashSet<>();
        for (int i = x * 3; i < x * 3 + 3; i++) {
          for (int j = y * 3; j < y * 3 + 3; j++) {
            if (board[i][j] != '.') {
              if (!set.add(board[i][j])) {
                return false;
              }
            }
          }
        }
      }
    }
    return true;
  }
}
