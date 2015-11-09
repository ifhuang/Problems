package leetcode.algorithms;

// https://leetcode.com/problems/smallest-rectangle-enclosing-black-pixels/
// An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The
// black pixels are connected, i.e., there is only one black region. Pixels are connected
// horizontally and vertically. Given the location (x, y) of one of the black pixels, return the
// area of the smallest (axis-aligned) rectangle that encloses all black pixels.
// For example, given the following image:
// [
// "0010",
// "0110",
// "0100"
// ]
// and x = 0, y = 2,
// Return 6.
public class SmallestRectangleEnclosingBlackPixels {
  private int x1, x2, y1, y2;

  public int minArea(char[][] image, int x, int y) {
    x1 = x2 = x;
    y1 = y2 = y;
    int m = image.length;
    int n = image[0].length;
    boolean[][] f = new boolean[m][n];
    f[x][y] = true;
    dfs(image, f, m, n, x, y);
    return (x2 - x1 + 1) * (y2 - y1 + 1);
  }

  private void dfs(char[][] image, boolean[][] f, int m, int n, int x, int y) {
    int[][] d = { {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    for (int i = 0; i < d.length; i++) {
      int nx = x + d[i][0];
      int ny = y + d[i][1];
      if (nx >= 0 && nx < m && ny >= 0 && ny < n && !f[nx][ny] && image[nx][ny] == '1') {
        x1 = Math.min(x1, nx);
        x2 = Math.max(x2, nx);
        y1 = Math.min(y1, ny);
        y2 = Math.max(y2, ny);
        f[nx][ny] = true;
        dfs(image, f, m, n, nx, ny);
      }
    }
  }

  public int minArea2(char[][] image, int x, int y) {
    int left = searchColumns(image, 0, y, true);
    int right = searchColumns(image, y + 1, image[0].length, false);
    int top = searchRows(image, 0, x, true);
    int bottom = searchRows(image, x + 1, image.length, false);
    return (right - left) * (bottom - top);
  }

  private int searchRows(char[][] image, int i, int j, boolean opt) {
    while (i != j) {
      int k = 0, m = (i + j) / 2;
      for (; k < image[0].length; ++k)
        if (image[m][k] == '1')
          break;
      if (k < image[0].length == opt)
        j = m;
      else
        i = m + 1;
    }
    return i;
  }

  private int searchColumns(char[][] image, int i, int j, boolean opt) {
    while (i != j) {
      int k = 0, m = (i + j) / 2;
      for (; k < image.length; ++k)
        if (image[k][m] == '1')
          break;
      if (k < image.length == opt)
        j = m;
      else
        i = m + 1;
    }
    return i;
  }
}
