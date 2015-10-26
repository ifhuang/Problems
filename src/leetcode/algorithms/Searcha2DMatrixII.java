package leetcode.algorithms;

import java.util.Arrays;

// https://leetcode.com/problems/search-a-2d-matrix-ii/
public class Searcha2DMatrixII {
  public boolean searchMatrix(int[][] matrix, int target) {
    return searchRow(matrix, target, 0, matrix[0].length);
  }

  private boolean searchRow(int[][] matrix, int target, int row, int end) {
    if (matrix.length == row || end == 0) {
      return false;
    }
    int index = Arrays.binarySearch(matrix[row], 0, end, target);
    return index >= 0 ? true : searchRow(matrix, target, row + 1, -index - 1);
  }

  public boolean searchMatrix2(int[][] matrix, int target) {
    int m = matrix.length;
    if (m == 0) {
      return false;
    }
    int n = matrix[0].length;
    int i = 0;
    int j = n - 1;
    while (i < m && j >= 0) {
      if (matrix[i][j] == target) {
        return true;
      } else if (matrix[i][j] < target) {
        i++;
      } else {
        j--;
      }
    }
    return false;
  }
}
