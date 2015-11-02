package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CleanerRobot {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  private static int ans;

  static void solve() throws Exception {
    ans = 0;
    int w = nextInt(), h = nextInt();
    char[][] c = new char[w][h];
    for (int i = 0; i < w; i++) {
      c[i] = next().toCharArray();
    }
    int[][] d = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    boolean[][][] v = new boolean[w][h][d.length];
    for (int i = 0; i < w; i++) {
      for (int j = 0; j < h; j++) {
        int k = "URDL".indexOf(c[i][j]);
        if (k != -1) {
          dfs(w, h, c, i, j, k, v, d);
        }
      }
    }
    out.println(ans + 1);
  }

  static void dfs(int w, int h, char[][] c, int x, int y, int s, boolean[][][] v, int[][] d) {
    if (c[x][y] == '.') {
      c[x][y] = '+';
      ans++;
      v[x][y][s] = true;
    }
    for (int i = 0; i < d.length; i++) {
      int newS = (s + i) % d.length;
      int newX = x + d[newS][0];
      int newY = y + d[newS][1];
      if (newX >= 0 && newX < w && newY >= 0 && newY < h && c[newX][newY] != '*') {
        if (v[newX][newY][newS]) {
          break;
        }
        dfs(w, h, c, newX, newY, newS, v, d);
        break;
      }
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
