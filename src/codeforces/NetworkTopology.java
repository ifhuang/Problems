package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NetworkTopology {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static int n, m;
  static List<List<Integer>> g;

  static void solve() throws Exception {
    n = nextInt();
    m = nextInt();
    g = new ArrayList<>();
    for (int i = 0; i < n; i++)
      g.add(new ArrayList<>());
    for (int i = 0; i < m; i++) {
      int a = nextInt() - 1;
      int b = nextInt() - 1;
      g.get(a).add(b);
      g.get(b).add(a);
    }
    check();
  }

  static void check() {
    int[] c = new int[n - 1];
    for (List<Integer> list : g)
      c[list.size() - 1]++;
    if (c[0] == 2 && c[0] + c[1] == n)
      out.println("bus topology");
    else if (c[1] == n)
      out.println("ring topology");
    else if (c[0] == n - 1 && c[n - 2] == 1)
      out.println("star topology");
    else
      out.println("unknown topology");
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
