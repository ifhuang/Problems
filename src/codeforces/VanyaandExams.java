package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class VanyaandExams {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    long r = nextLong();
    long avg = nextLong();
    long aim = n * avg;
    List<Exam3> list = new ArrayList<>();
    long sum = 0;
    for (int i = 0; i < n; i++) {
      long a = nextLong();
      long b = nextLong();
      list.add(new Exam3(a, b));
      sum += a;
    }
    Collections.sort(list);
    long ans = 0;
    for (int i = 0; i < n; i++) {
      if (sum >= aim)
        break;
      long t = Math.min(aim - sum, r - list.get(i).a);
      sum += t;
      ans += t * list.get(i).b;
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


class Exam3 implements Comparable<Exam3> {
  long a, b;

  Exam3(long x, long y) {
    a = x;
    b = y;
  }

  @Override
  public int compareTo(Exam3 o) {
    return (int) (b - o.b);
  }
}
