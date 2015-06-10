package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CowsandSequence {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    int[] a = new int[n + 1];
    int[] x = new int[n + 1];
    int num = 1;
    long sum = 0;
    for (int i = 0; i < n; i++) {
      int j = nextInt();
      if (j == 1) {
        int ai = nextInt();
        int xi = nextInt();
        sum += ai * xi;
        x[ai - 1] += xi;
      } else if (j == 2) {
        int ki = nextInt();
        a[num] = ki;
        sum += a[num];
        num++;
      } else {
        sum -= a[num - 1] + x[num - 1];
        x[num - 2] += x[num - 1];
        x[num - 1] = 0;
        num--;
      }
      out.println((double) sum / num);
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
