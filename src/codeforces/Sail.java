package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Sail {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int t = nextInt();
    long sx = nextLong(), sy = nextLong(), ex = nextLong(), ey = nextLong();
    long dx = ex - sx;
    long dy = ey - sy;
    char[] c = next().toCharArray();
    for (int i = 0; i < t; i++) {
      if (dx > 0 && c[i] == 'E')
        dx--;
      else if (dx < 0 && c[i] == 'W')
        dx++;
      if (dy > 0 && c[i] == 'N')
        dy--;
      else if (dy < 0 && c[i] == 'S')
        dy++;
      if (dx == 0 && dy == 0) {
        out.println(i + 1);
        return;
      }
    }
    out.println(-1);
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
