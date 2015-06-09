package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NotoPalindromes {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt(), p = nextInt();
    char[] c = next().toCharArray();
    char max = (char) ('a' - 1 + p);
    for (int i = n - 1; i >= 0; i--)
      while (c[i] < max) {
        c[i]++;
        if ((i > 0 && c[i] == c[i - 1]) || (i > 1 && c[i] == c[i - 2]))
          continue;
        for (int j = i + 1; j < n; j++) {
          c[j] = 'a';
          if (c[j] > max)
            c[j] -= p;
          while ((j > 0 && c[j] == c[j - 1]) || (j > 1 && c[j] == c[j - 2])) {
            c[j]++;
            if (c[j] > max)
              c[j] -= p;
          }
        }
        out.println(new String(c));
        return;
      }
    out.println("NO");
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
