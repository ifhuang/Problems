package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class IceSkating {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int max = 1000;
    boolean[][] g = new boolean[max + 1][max + 1];
    int n = nextInt();
    for (int i = 0; i < n; i++)
      g[nextInt()][nextInt()] = true;
    int ans = 0;
    for (int i = 1; i <= max; i++)
      for (int j = 1; j <= max; j++)
        if (g[i][j]) {
          ans++;
          Queue<Snow> q = new LinkedList<>();
          q.offer(new Snow(i, j));
          g[i][j] = false;
          while (!q.isEmpty()) {
            Snow s = q.poll();
            int[][] d = { {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int k = 0; k < d.length; k++) {
              int x = s.x + d[k][0];
              int y = s.y + d[k][1];
              while (x >= 1 && x <= max && y >= 1 && y <= max) {
                if (g[x][y]) {
                  q.add(new Snow(x, y));
                  g[x][y] = false;
                }
                x += d[k][0];
                y += d[k][1];
              }
            }
          }
        }
    out.println(ans - 1);
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


class Snow {
  int x, y;

  Snow(int a, int b) {
    x = a;
    y = b;
  }
}
