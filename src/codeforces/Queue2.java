package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Queue2 {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    Set<Integer> from = new HashSet<>();
    Set<Integer> to = new HashSet<>();
    Map<Integer, Integer> fromTo = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int f = nextInt();
      int t = nextInt();
      from.add(f);
      to.add(t);
      fromTo.put(f, t);
    }
    int[] a = new int[n];
    for (int f : from)
      if (!to.contains(f)) {
        a[0] = f;
        break;
      }
    a[1] = fromTo.get(0);
    for (int i = 2; i < n; i++)
      a[i] = fromTo.get(a[i - 2]);
    for (int i = 0; i < n; i++)
      out.print(a[i] + " ");
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
