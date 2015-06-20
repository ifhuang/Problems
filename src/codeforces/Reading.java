package codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Reading {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt(), k = nextInt();
    List<Light> list = new ArrayList<>();
    for (int i = 1; i <= n; i++)
      list.add(new Light(i, nextInt()));
    Collections.sort(list);
    out.println(list.get(n - k).level);
    for (int i = n - k; i < n; i++)
      out.print(list.get(i).index + " ");
  }

  public static void main(String args[]) {
    try {
      in = new BufferedReader(new FileReader("input.txt"));
      out = new PrintWriter(new FileWriter("output.txt"));
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


class Light implements Comparable<Light> {
  int index;
  int level;

  Light(int a, int b) {
    index = a;
    level = b;
  }

  @Override
  public int compareTo(Light o) {
    return level - o.level;
  }
}
