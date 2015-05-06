package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NewYearBookReading {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    int m = nextInt();
    int[] w = nextIntArray(n, 0);
    int[] b = nextIntArray(m, 0);
    long ans = 0;
    Book first = new Book(-1);
    for (int i = 0; i < m; i++) {
      Book p = first;
      Book q = first.next;
      long t = 0;
      while (q != null)
        if (q.i == b[i]) {
          p.next = q.next;
          q.next = first.next;
          first.next = q;
          break;
        } else {
          t += w[q.i - 1];
          p = p.next;
          q = q.next;
        }
      if (q == null) {
        q = new Book(b[i]);
        q.next = first.next;
        first.next = q;
      }
      ans += t;
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


class Book {
  int i;
  Book next;

  Book(int a) {
    i = a;
    next = null;
  }
}
