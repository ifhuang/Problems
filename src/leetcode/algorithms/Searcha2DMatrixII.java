package leetcode.algorithms;

import java.util.Arrays;

public class Searcha2DMatrixII {
  public boolean searchMatrix(int[][] matrix, int target) {
    return searchRow(matrix, target, 0, matrix[0].length);
  }

  private boolean searchRow(int[][] matrix, int target, int row, int end) {
    if (matrix.length == row || end == 0)
      return false;
    int index = Arrays.binarySearch(matrix[row], 0, end, target);
    if (index >= 0)
      return true;
    return searchRow(matrix, target, row + 1, -index - 1);
  }

  public boolean searchMatrix2(int[][] matrix, int target) {
    int i = 0;
    int j = matrix[0].length - 1;
    while (i < matrix.length && j >= 0)
      if (matrix[i][j] == target)
        return true;
      else if (matrix[i][j] < target)
        i++;
      else
        j--;
    return false;
  }
}
