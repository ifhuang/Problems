package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Towers2 {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt(), k = nextInt();
    int[] a = nextIntArray(n, 0);
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      int maxI = maxI(a);
      int minI = minI(a);
      if (a[maxI] - a[minI] <= 1)
        break;
      else {
        a[maxI]--;
        a[minI]++;
        list.add(maxI + 1);
        list.add(minI + 1);
      }
    }
    out.print(a[maxI(a)] - a[minI(a)]);
    out.print(" ");
    out.println(list.size() / 2);
    for (int i = 0; i < list.size() / 2; i++) {
      out.print(list.get(i * 2));
      out.print(" ");
      out.println(list.get(i * 2 + 1));
    }
  }

  static int maxI(int[] a) {
    int maxI = 0;
    for (int i = 1; i < a.length; i++)
      if (a[i] > a[maxI])
        maxI = i;
    return maxI;
  }

  static int minI(int[] a) {
    int minI = 0;
    for (int i = 1; i < a.length; i++)
      if (a[i] < a[minI])
        minI = i;
    return minI;
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
