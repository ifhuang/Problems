package other;

public class RotateMatrix {
  public int[][] solve(int[][] matrix, boolean flag) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] ans = new int[n][m];
    if (flag) {
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          ans[j][m - 1 - i] = matrix[i][j];
        }
      }
    } else {
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          ans[n - 1 - j][i] = matrix[i][j];
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    RotateMatrix r = new RotateMatrix();
    int[][] matrix = { {1, 2, 3}, {4, 5, 6}};
    int[][] ans = r.solve(matrix, false);
    System.out.println(ans);
  }
}
