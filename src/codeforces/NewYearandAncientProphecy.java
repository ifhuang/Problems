package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NewYearandAncientProphecy {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static final long mod = 1000000007;
  static long[] num;
  static long[][] hash;
  static long[][] pref;

  static void solve() throws Exception {

    int n = nextInt();
    char[] s = next().toCharArray();

    num = new long[n + 1];
    for (int i = 1; i <= n; i++) {
      num[i] = s[i - 1] - '0';
    }

    hash = new long[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      hash[i][i] = num[i];
      for (int j = i + 1; j <= n; j++) {
        hash[i][j] = (10 * hash[i][j - 1] + num[j]) % mod;
      }
    }

    pref = new long[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        pref[j][i] = 1;
      }
    }
    for (int c = 2; c <= n; c++) {
      for (int d = c; d <= n; d++) {
        int b = c - 1;
        int a = b - (d - c);
        pref[c][d] = pref[b][b] - pref[Math.max(a, 0)][b];
        if (pref[c][d] < 0) {
          pref[c][d] += mod;
        }
        if (a >= 1 && cmp(a, b, c, d) < 0) {
          pref[c][d] += dp(a, b);
          if (pref[c][d] >= mod) {
            pref[c][d] -= mod;
          }
        }
        if (num[c] == 0) {
          pref[c][d] = 0;
        }
        pref[c][d] += pref[c - 1][d];
        if (pref[c][d] >= mod) {
          pref[c][d] -= mod;
        }
      }
    }

    long ans = 0;
    for (int i = 1; i <= n; i++) {
      ans = (ans + dp(i, n)) % mod;
    }
    out.println(ans);
  }

  static long cmp(int a, int b, int c, int d) {
    if (num[a] != num[c]) {
      return num[a] - num[c];
    }
    if (hash[a][b] == hash[c][d]) {
      return 0;
    }
    int low = 0, high = b - a;
    while (low < high) {
      int mid = (low + high) >>> 1;
      if (hash[a][a + mid] == hash[c][c + mid]) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return num[a + low] - num[c + low];
  }

  static long dp(int a, int b) {
    long x = pref[a][b] - pref[a - 1][b];
    if (x < 0) {
      x += mod;
    }
    return x;
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
