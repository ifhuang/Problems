package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Laptops {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    List<Laptop> list = new ArrayList<>();
    for (int i = 0; i < n; i++)
      list.add(new Laptop(nextInt(), nextInt()));
    Collections.sort(list);
    boolean flag = false;
    for (int i = 1; i < n; i++)
      if (list.get(i).b < list.get(i - 1).b) {
        flag = true;
        break;
      }
    if (flag)
      out.println("Happy Alex");
    else
      out.println("Poor Alex");
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

  static double nextDouble() throws IOException {
    return Double.parseDouble(next());
  }

  static double[] nextDoubleArray(int len, int start) throws IOException {
    double[] a = new double[len];
    for (int i = start; i < len; i++)
      a[i] = nextDouble();
    return a;
  }

  static BigInteger nextBigInteger() throws IOException {
    return new BigInteger(next());
  }

  static String next() throws IOException {
    while (tok == null || !tok.hasMoreTokens()) {
      tok = new StringTokenizer(in.readLine());
    }
    return tok.nextToken();
  }

  static String nextLine() throws IOException {
    tok = new StringTokenizer("");
    return in.readLine();
  }

}


class Laptop implements Comparable<Laptop> {
  int a;
  int b;

  Laptop(int x, int y) {
    a = x;
    b = y;
  }

  @Override
  public int compareTo(Laptop o) {
    return a - o.a;
  }
}
