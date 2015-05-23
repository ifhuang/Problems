package atcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Lock {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    StringBuilder[] sb = gen(n);
    out.println(sb.length - 1);
    for (StringBuilder sbi : sb)
      out.println(sbi);
  }

  static StringBuilder[] gen(int n) {
    if (n == 1) {
      StringBuilder[] sb = new StringBuilder[10];
      for (int i = 0; i < 10; i++)
        sb[i] = new StringBuilder(i + "");
      return sb;
    } else {
      StringBuilder[] pre = gen(n - 1);
      StringBuilder[] now = new StringBuilder[pre.length * 10];
      for (int i = 0; i < 10; i++)
        if (i % 2 == 0) {
          for (int j = 0; j < pre.length; j++) {
            now[pre.length * i + j] = new StringBuilder(i + "");
            now[pre.length * i + j].append(pre[j]);
          }
        } else {
          for (int j = 0; j < pre.length; j++) {
            now[pre.length * i + j] = new StringBuilder(i + "");
            now[pre.length * i + j].append(pre[pre.length - 1 - j]);
          }
        }
      return now;
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
