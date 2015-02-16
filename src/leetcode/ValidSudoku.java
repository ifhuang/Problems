package leetcode;

import java.util.HashSet;
import java.util.Set;

// https://oj.leetcode.com/problems/valid-sudoku/
public class ValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    int n = 9;
    for (int i = 0; i < n; i++) {
      Set<Character> set = new HashSet<>();
      for (int j = 0; j < n; j++)
        if (board[i][j] != '.')
          if (!set.add(board[i][j]))
            return false;
    }
    for (int i = 0; i < n; i++) {
      Set<Character> set = new HashSet<>();
      for (int j = 0; j < n; j++)
        if (board[j][i] != '.')
          if (!set.add(board[j][i]))
            return false;
    }
    for (int i = 0; i < n; i++) {
      Set<Character> set = new HashSet<>();
      for (int j = 0; j < n; j++) {
        int x = i / 3 * 3 + j / 3;
        int y = i % 3 * 3 + j % 3;
        if (board[x][y] != '.')
          if (!set.add(board[x][y]))
            return false;
      }
    }
    return true;
  }
}
