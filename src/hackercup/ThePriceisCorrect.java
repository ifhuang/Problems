package hackercup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ThePriceisCorrect {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int T = nextInt();
    for (int t = 1; t <= T; t++) {
      int N = nextInt();
      long P = nextLong();
      long[] B = nextLongArray(N, 0);
      long[] pre = new long[N + 1];
      for (int i = 1; i < N + 1; i++) {
        pre[i] = pre[i - 1] + B[i - 1];
      }
      long[] dp = new long[N + 1];
      for (int i = 1; i < N + 1; i++) {
        int low = 0, high = i;
        while (low < high) {
          int mid = (low + high) >>> 1;
          long x = pre[i] - pre[mid];
          if (x > P) {
            low = mid + 1;
          } else {
            high = mid;
          }
        }
        dp[i] = dp[i - 1] + i - low;
      }
      out.println(String.format("Case #%d: %d", t, dp[N]));
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

  static String next() throws IOException {
    while (tok == null || !tok.hasMoreTokens()) {
      tok = new StringTokenizer(in.readLine());
    }
    return tok.nextToken();
  }

}
