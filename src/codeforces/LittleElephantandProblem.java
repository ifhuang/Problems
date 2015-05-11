package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LittleElephantandProblem {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    int[] a = nextIntArray(n, 0);
    int first = -1;
    int second = -1;
    int third = -1;
    for (int i = 1; i < n; i++)
      if (a[i] < a[i - 1])
        if (first == -1)
          first = i;
        else if (second == -1)
          second = i;
        else {
          third = i;
          break;
        }
    if (first == -1)
      out.println("YES");
    else if (second == -1) {
      int i = first;
      while (i - 2 >= 0 && a[i - 1] == a[i - 2])
        i--;
      while (first + 1 < n && a[first + 1] == a[first])
        first++;
      int t = a[i - 1];
      a[i - 1] = a[first];
      a[first] = t;
      out.println(check(a) ? "YES" : "NO");
    } else if (third == -1) {
      int t = a[first - 1];
      a[first - 1] = a[second];
      a[second] = t;
      out.println(check(a) ? "YES" : "NO");
    } else
      out.println("NO");
  }

  static boolean check(int[] a) {
    for (int i = 1; i < a.length; i++)
      if (a[i] < a[i - 1])
        return false;
    return true;
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
