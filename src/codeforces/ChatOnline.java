package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ChatOnline {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int p = nextInt(), q = nextInt(), l = nextInt(), r = nextInt();
    int max = 1000;
    int[] Z = new int[max + 1];
    for (int i = 0; i < p; i++) {
      int a = nextInt(), b = nextInt();
      for (int j = a; j <= b; j++)
        Z[j]++;
    }
    int[] preSum = new int[max + 2];
    for (int i = 1; i <= max + 1; i++)
      preSum[i] = preSum[i - 1] + Z[i - 1];
    int[][] X = new int[q][2];
    for (int i = 0; i < q; i++) {
      X[i][0] = nextInt();
      X[i][1] = nextInt();
    }
    int ans = 0;
    for (int i = l; i <= r; i++)
      for (int j = 0; j < q; j++) {
        int a = X[j][0] + i;
        int b = X[j][1] + i;
        if (a <= max) {
          b = Math.min(b, max);
          if (preSum[b + 1] - preSum[a] > 0) {
            ans++;
            break;
          }
        }
      }
    out.println(ans);
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
