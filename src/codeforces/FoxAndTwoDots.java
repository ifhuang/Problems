package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FoxAndTwoDots {
  static int n;
  static int m;
  static char[][] board;
  static int[][] used;
  static int[][] d = { {0, 1}, {1, 0}, {0, -1}, {-1, 0}};
  static int t = 1;
  static boolean flag;

  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line = in.readLine();
    String[] part = line.split(" ");
    n = Integer.parseInt(part[0]);
    m = Integer.parseInt(part[1]);
    board = new char[n][m];
    used = new int[n][m];
    for (int i = 0; i < n; i++)
      board[i] = in.readLine().toCharArray();
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        dfs(i, j, i, j);
    if (flag)
      out.println("Yes");
    else
      out.println("No");
    out.close();
    in.close();
  }

  static void dfs(int x, int y, int preX, int preY) {
    used[x][y] = t;
    t++;
    for (int i = 0; i < 4; i++) {
      int X = (d[i][0] + x);
      int Y = (d[i][1] + y);
      if (X < 0 || Y < 0 || Y >= m || X >= n || preX == X && preY == Y
          || board[x][y] != board[X][Y])
        continue;
      if (used[X][Y] == 0)
        dfs(X, Y, x, y);
      else if (used[X][Y] > 0 && used[x][y] - used[X][Y] >= 3)
        flag = true;
    }
    used[x][y] = -1;
  }
}
