package other;

public class ContinousThreeSum {
  public int sum(int[][] arr, int row, int column) {
    int ans = Integer.MIN_VALUE;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        if (j + 2 < column) {
          ans = Math.max(ans, arr[i][j] + arr[i][j + 1] + arr[i][j + 2]);
        }
        if (i + 2 < row) {
          ans = Math.max(ans, arr[i][j] + arr[i + 1][j] + arr[i + 2][j]);
        }
        if (j + 2 < column && i + 2 < row) {
          ans = Math.max(ans, arr[i][j] + arr[i + 1][j + 1] + arr[i + 2][j + 2]);
        }
      }
    }
    return ans;
  }
}
