package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MashmokhandNumbers {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt(), k = nextInt();
    if (k < n / 2 || (n == 1 && k != 0))
      out.println(-1);
    else if (n == 1 && k == 0)
      out.println(1);
    else {
      int i = k - (n / 2 - 1);
      List<Integer> la = new ArrayList<>();
      List<Integer> lb = new ArrayList<>();
      la.add(i);
      lb.add(2 * i);
      for (int j = 1; la.size() < n / 2; j += 2)
        if (j != i && j + 1 != i && j + 1 != 2 * i) {
          la.add(j);
          lb.add(j + 1);
        }
      if (n % 2 == 1)
        lb.add(100000000);
      for (int j = 0; j < lb.size(); j++) {
        if (j < la.size())
          out.print(la.get(j) + " ");
        out.print(lb.get(j) + " ");
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
