package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Maze {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt(), m = nextInt(), k = nextInt(), s = 0;
    char[][] c = new char[n][m];
    int x = 0, y = 0;
    for (int i = 0; i < n; i++) {
      c[i] = next().toCharArray();
      for (int j = 0; j < m; j++)
        if (c[i][j] == '.') {
          x = i;
          y = j;
          s++;
        }
    }
    int t = s - k;
    Queue<Cell> queue = new LinkedList<>();
    c[x][y] = 'X';
    t--;
    if (t == 0) {
      print(c, n, m);
      return;
    }
    queue.offer(new Cell(x, y));
    int[][] d = { {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    while (true) {
      Cell cell = queue.poll();
      for (int i = 0; i < d.length; i++) {
        int x1 = cell.x + d[i][0];
        int y1 = cell.y + d[i][1];
        if (x1 >= 0 && x1 < n && y1 >= 0 && y1 < m && c[x1][y1] == '.') {
          c[x1][y1] = 'X';
          t--;
          if (t == 0) {
            print(c, n, m);
            return;
          }
          queue.offer(new Cell(x1, y1));
        }
      }
    }
  }

  static void print(char[][] c, int n, int m) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++)
        if (c[i][j] == '.')
          out.print('X');
        else if (c[i][j] == 'X')
          out.print('.');
        else
          out.print('#');
      out.println();
    }
  }

  public static void main(String args[]) {
    try {
      in = new BufferedReader(new InputStreamReader(System.in));
      out = new PrintWriter(new OutputStreamWriter(System.out));
      solve();
      in.close();
      out.close();
    } catch (Throwable e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

  static int nextInt() throws IOException {
    return Integer.parseInt(next());
  }

  static int[] nextIntArray(int len, int start) throws IOException {
    int[] a = new int[len];
    for (int i = start; i < len; i++)
      a[i] = nextInt();
    return a;
  }

  static long nextLong() throws IOException {
    return Long.parseLong(next());
  }

  static long[] nextLongArray(int len, int start) throws IOException {
    long[] a = new long[len];
    for (int i = start; i < len; i++)
      a[i] = nextLong();
    return a;
  }

  static String next() throws IOException {
    while (tok == null || !tok.hasMoreTokens()) {
      tok = new StringTokenizer(in.readLine());
    }
    return tok.nextToken();
  }

}


class Cell {

  int x, y;

  Cell(int a, int b) {
    x = a;
    y = b;
  }

}
