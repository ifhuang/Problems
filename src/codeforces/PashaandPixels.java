package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PashaandPixels {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line = in.readLine();
    String[] part = line.split(" ");
    int n = Integer.parseInt(part[0]);
    int m = Integer.parseInt(part[1]);
    boolean[][] board = new boolean[n + 2][m + 2];
    int k = Integer.parseInt(part[2]);
    boolean flag = false;
    int i = 1;
    for (; i <= k; i++) {
      part = in.readLine().split(" ");
      int x = Integer.parseInt(part[0]);
      int y = Integer.parseInt(part[1]);
      board[x][y] = true;
      if (check(board, x, y)) {
        flag = true;
        break;
      }
    }
    if (flag)
      out.println(i);
    else
      out.println(0);
    out.close();
    in.close();
  }

  static boolean check(boolean[][] board, int x, int y) {
    return board[x - 1][y] && board[x][y + 1] && board[x - 1][y + 1] || board[x][y + 1]
        && board[x + 1][y] && board[x + 1][y + 1] || board[x][y - 1] && board[x + 1][y]
        && board[x + 1][y - 1] || board[x - 1][y] && board[x][y - 1] && board[x - 1][y - 1];
  }
}
