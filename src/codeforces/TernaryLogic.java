package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TernaryLogic {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int a = nextInt(), c = nextInt();
    String sa = Integer.toString(a, 3);
    String sc = Integer.toString(c, 3);
    int al = sa.length();
    int cl = sc.length();
    int max = Math.max(al, cl);
    for (int i = 0; i < max - al; i++)
      sa = "0" + sa;
    for (int i = 0; i < max - cl; i++)
      sc = "0" + sc;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < max; i++) {
      int bi = sc.charAt(i) - sa.charAt(i);
      if (bi < 0)
        bi += 3;
      sb.append(bi);
    }
    out.println(Long.parseLong(sb.toString(), 3));
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
