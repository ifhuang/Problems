package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class PearlsinaRow {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    long[] a = nextLongArray(n, 0);
    List<Integer> first = new ArrayList<>();
    List<Integer> second = new ArrayList<>();
    Set<Long> set = new HashSet<>();
    int left = 0;
    int right = 0;
    for (int i = 0; i < n; i++) {
      if (set.contains(a[i])) {
        right = i;
        first.add(left);
        second.add(right);
        left = i + 1;
        set = new HashSet<>();
      } else {
        set.add(a[i]);
      }
    }
    if (first.isEmpty()) {
      out.println(-1);
      return;
    }
    second.set(second.size() - 1, n - 1);
    out.println(first.size());
    for (int i = 0; i < first.size(); i++) {
      out.println((first.get(i) + 1) + " " + (second.get(i) + 1));
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
