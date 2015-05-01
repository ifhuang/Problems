package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.StringTokenizer;

public class IceCave {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static int n;
  static int m;
  static char[][] c;
  static char[][] copy;
  static int r1, c1, r2, c2;
  static int[][] d = { {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  static Queue<Ice> queue = new LinkedList<>();

  static void solve() throws Exception {
    n = nextInt();
    m = nextInt();
    c = new char[n][m];
    copy = new char[n][m];
    for (int i = 0; i < n; i++) {
      c[i] = next().toCharArray();
      copy[i] = Arrays.copyOf(c[i], m);
    }
    r1 = nextInt() - 1;
    c1 = nextInt() - 1;
    r2 = nextInt() - 1;
    c2 = nextInt() - 1;
    c[r1][c1] = '.';
    if (r1 == r2 && c1 == c2)
      out.println(check(r1, c1, true) ? "YES" : "NO");
    else
      search(r1, c1);
  }

  static void search(int x, int y) {
    queue.offer(new Ice(x, y));
    while (!queue.isEmpty()) {
      Ice ice = queue.poll();
      for (int i = 0; i < d.length; i++) {
        int x1 = ice.x + d[i][0];
        int y1 = ice.y + d[i][1];
        if (x1 >= 0 && x1 < n && y1 >= 0 && y1 < m)
          if (x1 == r2 && y1 == c2) {
            if (c[r2][c2] == 'X' || check(r2, c2, false)) {
              out.println("YES");
              return;
            }
          } else if (copy[x1][y1] == '.') {
            copy[x1][y1] = 'X';
            queue.offer(new Ice(x1, y1));
          }
      }
    }
    out.println("NO");
  }

  static boolean check(int x, int y, boolean flag) {
    int count = 0;
    for (int i = 0; i < d.length; i++) {
      int x1 = x + d[i][0];
      int y1 = y + d[i][1];
      if (x1 >= 0 && x1 < n && y1 >= 0 && y1 < m && c[x1][y1] == '.')
        count++;
    }
    return flag ? count > 0 : count > 1;
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

  static double nextDouble() throws IOException {
    return Double.parseDouble(next());
  }

  static double[] nextDoubleArray(int len, int start) throws IOException {
    double[] a = new double[len];
    for (int i = start; i < len; i++)
      a[i] = nextDouble();
    return a;
  }

  static BigInteger nextBigInteger() throws IOException {
    return new BigInteger(next());
  }

  static String next() throws IOException {
    while (tok == null || !tok.hasMoreTokens()) {
      tok = new StringTokenizer(in.readLine());
    }
    return tok.nextToken();
  }

  static String nextLine() throws IOException {
    tok = new StringTokenizer("");
    return in.readLine();
  }

  static void shuffleArray(long[] array) {
    Random random = new Random();
    for (int i = array.length - 1; i > 0; i--) {
      int index = random.nextInt(i + 1);
      long temp = array[index];
      array[index] = array[i];
      array[i] = temp;
    }
  }

  static boolean hasNext() throws IOException {
    while (tok == null || !tok.hasMoreTokens()) {
      String s = in.readLine();
      if (s == null) {
        return false;
      }
      tok = new StringTokenizer(s);
    }
    return true;
  }

}


class Ice {
  int x;
  int y;

  Ice(int a, int b) {
    x = a;
    y = b;
  }
}
