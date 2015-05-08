package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class ShowerLine {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    List<List<List<Integer>>> list = new LinkedList<>();
    List<List<Integer>> item = new LinkedList<>();
    List<Integer> seq = new LinkedList<>();
    seq.add(1);
    item.add(seq);
    list.add(item);
    for (int i = 2; i <= 5; i++) {
      item = new LinkedList<>();
      List<List<Integer>> pre = list.get(i - 2);
      for (List<Integer> p : pre)
        for (int j = 0; j <= p.size(); j++) {
          seq = new LinkedList<>(p);
          seq.add(j, i);
          item.add(seq);
        }
      list.add(item);
    }
    long[][] m = new long[5][5];
    for (int i = 0; i < 5; i++)
      m[i] = nextLongArray(5, 0);
    long ans = 0;
    for (List<Integer> li : list.get(4)) {
      long t = 0;
      for (int j = 0; j < 5; j++)
        for (int i = j; i + 1 < 5; i += 2)
          t += m[li.get(i) - 1][li.get(i + 1) - 1] + m[li.get(i + 1) - 1][li.get(i) - 1];
      ans = Math.max(ans, t);
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
