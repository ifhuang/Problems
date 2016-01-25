package hackercup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BoomerangDecoration {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int T = nextInt();
    for (int t = 1; t <= T; t++) {
      int N = nextInt();
      char[] A = next().toCharArray();
      char[] B = next().toCharArray();

      int leftBase = 0;
      int[] left = new int[N + 1];
      for (int i = 1; i < N + 1; i++) {
        if (i > 1) {
          if (B[i - 1] == B[i - 2]) {
            leftBase--;
          }
        }
        if (A[i - 1] == B[i - 1]) {
          left[i] = left[i - 1];
        } else {
          left[i] = i + leftBase;
        }
      }

      int rightBase = 0;
      int[] right = new int[N + 1];
      for (int i = N - 1; i >= 0; i--) {
        if (i < N - 1) {
          if (B[i] == B[i + 1]) {
            rightBase--;
          }
        }
        if (A[i] == B[i]) {
          right[i] = right[i + 1];
        } else {
          right[i] = N - i + rightBase;
        }
      }

      int ans = N;
      for (int i = 0; i < N + 1; i++) {
        ans = Math.min(ans, Math.max(left[i], right[i]));
      }

      out.println(String.format("Case #%d: %d", t, ans));
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
