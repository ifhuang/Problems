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

public class FoxDividingCheese {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    long a = nextLong(), b = nextLong();
    List<Long> la = gen(a);
    List<Long> lb = gen(b);
    int i = la.size() - 1, j = lb.size() - 1;
    while (i >= 0 && j >= 0)
      if (la.get(i).equals(lb.get(j)))
        break;
      else if (la.get(i).compareTo(lb.get(j)) > 0)
        i--;
      else
        j--;
    long x = la.get(i);
    int xa = count(a, x);
    int xb = count(b, x);
    out.println((xa == -1 || xb == -1) ? -1 : xa + xb);
  }

  static List<Long> gen(long a) {
    List<Long> list = new ArrayList<>();
    for (long i = 1; i * i <= a; i++)
      if (a % i == 0) {
        list.add(i);
        if (a / i != i)
          list.add(a / i);
      }
    Collections.sort(list);
    return list;
  }

  static int count(long a, long b) {
    if (a == b)
      return 0;
    long c = a / b;
    int count = 0;
    while (c != 1)
      if (c % 2 == 0) {
        c /= 2;
        count++;
      } else if (c % 3 == 0) {
        c /= 3;
        count++;
      } else if (c % 5 == 0) {
        c /= 5;
        count++;
      } else {
        return -1;
      }
    return count;
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
