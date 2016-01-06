package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class LaurentyandShop {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    int[] a1 = nextIntArray(n - 1, 0);
    int[] a2 = nextIntArray(n - 1, 0);
    int[] b = nextIntArray(n, 0);
    int[] pre1 = new int[n];
    for (int i = 1; i < n; i++) {
      pre1[i] = pre1[i - 1] + a1[i - 1];
    }
    int[] pre2 = new int[n];
    for (int i = 1; i < n; i++) {
      pre2[i] = pre2[i - 1] + a2[i - 1];
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      int t1 = pre1[i] - pre1[0];
      int t2 = b[i];
      int t3 = pre2[n - 1] - pre2[i];
      int t = t1 + t2 + t3;
      pq.offer(t);
    }
    out.println(pq.poll() + pq.poll());
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
