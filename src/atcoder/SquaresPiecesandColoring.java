package atcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SquaresPiecesandColoring {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    long[] s = new long[n];
    long[] c = new long[n];
    long min = Long.MAX_VALUE;
    long sum = 0;
    for (int i = 0; i < n; i++) {
      s[i] = nextLong();
      c[i] = nextLong();
      min = Math.min(min, s[i]);
      sum += c[i];
    }
    int[] flag = new int[(int) (sum + 100)];
    for (int i = 0; i < n; i++) {
      long j = s[i] - min;
      long k = 0;
      while (k < c[i]) {
        long x = j / 32;
        long y = j % 32;
        if (((flag[(int) x]) & (1 << y)) == 0) {
          flag[(int) x] |= (1 << y);
          k++;
        }
        j++;
      }
      out.println(j - 1 + min);
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
