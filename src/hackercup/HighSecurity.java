package hackercup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HighSecurity {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int T = nextInt();
    for (int t = 1; t <= T; t++) {
      int N = nextInt();
      char[][] b = new char[2][N];
      b[0] = next().toCharArray();
      b[1] = next().toCharArray();
      out.println(String.format("Case #%d: %d", t, func(b, N)));
    }
  }

  static int func(char[][] b, int N) {
    int ans = 0;

    for (int i = 0; i < N; i++) {
      if (b[0][i] == '.') {
        if (i == 0) {
          if (((N == 1) || (N > 1 && b[0][1] == 'X')) && b[1][0] == '.') {
            ans++;
            b[0][0] = 'G';
            span(b, N, 1, 0);
          }
        } else if (i == N - 1) {
          if (b[0][N - 2] == 'X' && b[1][N - 1] == '.') {
            ans++;
            b[0][N - 1] = 'G';
            span(b, N, 1, N - 1);
          }
        } else {
          if (b[0][i - 1] == 'X' && b[0][i + 1] == 'X' && b[1][i] == '.') {
            ans++;
            b[0][i] = 'G';
            span(b, N, 1, i);
          }
        }
      }
    }
    for (int i = 0; i < N; i++) {
      if (b[1][i] == '.') {
        if (i == 0) {
          if (((N == 1) || (N > 1 && b[1][1] == 'X')) && b[0][0] == '.') {
            ans++;
            b[1][0] = 'G';
            span(b, N, 0, 0);
          }
        } else if (i == N - 1) {
          if (b[1][N - 2] == 'X' && b[0][N - 1] == '.') {
            ans++;
            b[1][N - 1] = 'G';
            span(b, N, 0, N - 1);
          }
        } else {
          if (b[1][i - 1] == 'X' && b[1][i + 1] == 'X' && b[0][i] == '.') {
            ans++;
            b[1][i] = 'G';
            span(b, N, 0, i);
          }
        }
      }
    }

    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < N; j++) {
        if (b[i][j] == '.') {
          ans++;
          span(b, N, i, j);
        }
      }
    }

    return ans;
  }

  static void span(char[][] b, int N, int x, int y) {
    b[x][y] = 'G';
    for (int y1 = y + 1; y1 < N && b[x][y1] == '.'; y1++) {
      b[x][y1] = 'G';
    }
    for (int y2 = y - 1; y2 >= 0 && b[x][y2] == '.'; y2--) {
      b[x][y2] = 'G';
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
