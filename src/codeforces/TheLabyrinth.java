package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class TheLabyrinth {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static int[][] d = { {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  static int id;
  static int count;

  static void solve() throws Exception {
    int n = nextInt(), m = nextInt();
    char[][] old = new char[n][m];
    int[][] c = new int[n][m];
    for (int i = 0; i < n; i++) {
      old[i] = next().toCharArray();
      for (int j = 0; j < m; j++) {
        c[i][j] = (old[i][j] == '*' ? -1 : -2);
      }
    }

    id = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (c[i][j] == -2) {
          count = 0;
          dfs(c, n, m, i, j);
          map.put(id, count);
          id++;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (old[i][j] == '*') {
          int ans = 1;
          Set<Integer> set = new HashSet<>();
          for (int k = 0; k < d.length; k++) {
            int x = i + d[k][0];
            int y = j + d[k][1];
            if (x >= 0 && x < n && y >= 0 && y < m && c[x][y] != -1) {
              set.add(c[x][y]);
            }
          }
          for (int id : set) {
            ans += map.get(id);
          }
          ans %= 10;
          old[i][j] = (char) ('0' + ans);
        }
      }
      out.println(new String(old[i]));
    }
  }

  static void dfs(int[][] c, int n, int m, int x, int y) {
    count++;
    c[x][y] = id;
    for (int i = 0; i < d.length; i++) {
      int nx = x + d[i][0];
      int ny = y + d[i][1];
      if (nx >= 0 && nx < n && ny >= 0 && ny < m && c[nx][ny] == -2) {
        dfs(c, n, m, nx, ny);
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
