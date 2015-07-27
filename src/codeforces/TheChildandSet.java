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

public class TheChildandSet {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int sum = nextInt(), limit = nextInt();
    List<LowBit> list = new ArrayList<>();
    for (int i = 1; i <= limit; i++)
      list.add(new LowBit(i, getB(i)));
    Collections.sort(list);
    List<Integer> ans = new ArrayList<>();
    for (LowBit lb : list)
      if (lb.b <= sum) {
        sum -= lb.b;
        ans.add(lb.a);
      }
    if (sum == 0) {
      out.println(ans.size());
      for (int i : ans)
        out.print(i + " ");
    } else
      out.println(-1);
  }

  static int getB(int i) {
    for (int j = 1;; j <<= 1)
      if ((i & j) > 0)
        return j;
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


class LowBit implements Comparable<LowBit> {
  int a;
  int b;

  LowBit(int a, int b) {
    this.a = a;
    this.b = b;
  }

  @Override
  public int compareTo(LowBit o) {
    return o.b - b;
  }


}
