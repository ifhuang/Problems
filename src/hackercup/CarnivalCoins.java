package hackercup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CarnivalCoins {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int T = nextInt();
    for (int t = 1; t <= T; t++) {
      int N = nextInt(), K = nextInt();
      double p = nextDouble();

      double[][] dp1 = new double[N + 1][N + 1];
      dp1[0][0] = 1;
      for (int i = 1; i <= N; i++) {
        dp1[i][0] = dp1[i - 1][0] * (1 - p);
        dp1[i][i] = dp1[i - 1][i - 1] * p;
      }
      for (int i = 2; i <= N; i++) {
        for (int j = 1; j < i; j++) {
          dp1[i][j] = dp1[i - 1][j - 1] * p + dp1[i - 1][j] * (1 - p);
        }
      }

      double[] dp2 = new double[N + 1];
      for (int i = 1; i <= N; i++) {
        dp2[i] = 0;
        for (int j = K; j <= i; j++) {
          dp2[i] += dp1[i][j];
        }
      }

      double[] dp3 = new double[N + 1];
      dp3[0] = 0;
      for (int i = 1; i <= N; i++) {
        dp3[i] = 0;
        for (int j = 0; j < i; j++) {
          dp3[i] = Math.max(dp3[i], dp3[j] + dp2[i - j]);
        }
      }

      out.println(String.format("Case #%d: %.9f", t, dp3[N]));
    }
  }

  public static void main(String args[]) {
    try {
      in = new BufferedReader(new InputStreamReader(System.in));
      // in = new BufferedReader(new FileReader(args[0]));
      out = new PrintWriter(new OutputStreamWriter(System.out));
      // out = new PrintWriter(args[1]);
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

  static double nextDouble() throws IOException {
    return Double.parseDouble(next());
  }

  static double[] nextDoubleArray(int len, int start) throws IOException {
    double[] a = new double[len];
    for (int i = start; i < len; i++)
      a[i] = nextDouble();
    return a;
  }

  static String next() throws IOException {
    while (tok == null || !tok.hasMoreTokens()) {
      tok = new StringTokenizer(in.readLine());
    }
    return tok.nextToken();
  }

}
