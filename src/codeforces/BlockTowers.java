package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BlockTowers {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    long n = nextLong();
    long m = nextLong();
    if (n == 0) {
      out.println(m * 3);
      return;
    }
    if (m == 0) {
      out.println(n * 2);
      return;
    }
    long i = n - 1;
    long j = m - 1;
    long curI = 2;
    long curJ = 3;
    while (i > 0 && j > 0) {
      if (curI + 2 == curJ + 3) {
        long t1 = curI + 2 * i;
        long t2 = curJ + 3 * (j + 1);
        long m1 = Math.max(t1, t2);
        long t3 = curI + 2 * (i + 1);
        long t4 = curJ + 3 * j;
        long m2 = Math.max(t3, t4);
        if (m1 < m2) {
          i--;
          curI += 2;
          j--;
          curJ += 6;
        } else {
          i--;
          curI += 4;
          j--;
          curJ += 3;
        }
      } else if (curI < curJ) {
        i--;
        curI += 2;
      } else if (curI > curJ) {
        j--;
        curJ += 3;
      }
    }
    curI += i * 2;
    curJ += j * 3;
    out.println(Math.max(curI, curJ));
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
