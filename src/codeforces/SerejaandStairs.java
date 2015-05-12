package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SerejaandStairs {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    int max = 5000;
    int[] num = new int[max + 1];
    for (int i = 0; i < n; i++)
      num[nextInt()]++;
    List<Integer> list = new ArrayList<>();
    list.add(0);
    for (int i = 1; i <= max; i++)
      if (num[i] > 0 && i > list.get(list.size() - 1)) {
        list.add(i);
        num[i]--;
      }
    for (int i = max; i >= 1; i--)
      if (num[i] > 0 && i < list.get(list.size() - 1)) {
        list.add(i);
        num[i]--;
      }
    out.println(list.size() - 1);
    for (int i = 1; i < list.size(); i++)
      out.print(list.get(i) + " ");
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
