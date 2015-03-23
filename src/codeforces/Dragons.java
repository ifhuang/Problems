package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Dragons {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int s = nextInt();
    int n = nextInt();
    List<Dragon> list = new ArrayList<>();
    for (int i = 0; i < n; i++)
      list.add(new Dragon(nextInt(), nextInt()));
    Collections.sort(list);
    int i = 0;
    for (; i < n; i++)
      if (s <= list.get(i).x)
        break;
      else
        s += list.get(i).y;
    if (i == n)
      out.println("YES");
    else
      out.println("NO");
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

  static long nextLong() throws IOException {
    return Long.parseLong(next());
  }

  static double nextDouble() throws IOException {
    return Double.parseDouble(next());
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

}


class Dragon implements Comparable<Dragon> {
  int x;
  int y;

  Dragon(int a, int b) {
    x = a;
    y = b;
  }

  @Override
  public int compareTo(Dragon o) {
    return x - o.x;
  }
}
