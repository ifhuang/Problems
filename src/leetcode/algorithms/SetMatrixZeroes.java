package leetcode.algorithms;

// https://leetcode.com/problems/set-matrix-zeroes/
public class SetMatrixZeroes {
  // time O(n^2), space O(1)
  public void setZeroes(int[][] matrix) {
    int fr = 1, fc = 1;
    int m = matrix.length;
    if (m == 0) {
      return;
    }
    int n = matrix[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          if (i == 0 && j == 0) {
            fr = 0;
            fc = 0;
          } else if (i == 0) {
            fr = 0;
            matrix[0][j] = 0;
          } else if (j == 0) {
            fc = 0;
            matrix[i][0] = 0;
          } else {
            matrix[0][j] = 0;
            matrix[i][0] = 0;
          }
        }
      }
    }
    for (int i = 1; i < m; i++) {
      if (matrix[i][0] == 0) {
        for (int j = 0; j < n; j++) {
          matrix[i][j] = 0;
        }
      }
    }
    for (int j = 1; j < n; j++) {
      if (matrix[0][j] == 0) {
        for (int i = 0; i < m; i++) {
          matrix[i][j] = 0;
        }
      }
    }
    if (fr == 0) {
      for (int j = 0; j < n; j++) {
        matrix[0][j] = 0;
      }
    }
    if (fc == 0) {
      for (int i = 0; i < m; i++) {
        matrix[i][0] = 0;
      }
    }
  }
}
