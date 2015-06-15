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

public class ChoosingLaptop {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    List<Laptop2> list = new ArrayList<>();
    for (int i = 1; i <= n; i++)
      list.add(new Laptop2(nextInt(), nextInt(), nextInt(), nextInt(), i));
    Collections.sort(list);
    for (int i = 0; i < n; i++) {
      Laptop2 a = list.get(i);
      int j = i + 1;
      for (; j < n; j++) {
        Laptop2 b = list.get(j);
        if (a.speed < b.speed && a.ram < b.ram && a.hdd < b.hdd)
          break;
      }
      if (j == n) {
        out.println(a.index);
        return;
      }
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


class Laptop2 implements Comparable<Laptop2> {
  int speed, ram, hdd, cost, index;

  public Laptop2(int a, int b, int c, int d, int e) {
    speed = a;
    ram = b;
    hdd = c;
    cost = d;
    index = e;
  }

  @Override
  public int compareTo(Laptop2 o) {
    return cost - o.cost;
  }
}
