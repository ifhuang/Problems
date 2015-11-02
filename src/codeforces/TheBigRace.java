package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class TheBigRace {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    BigInteger t = new BigInteger(next());
    BigInteger w = new BigInteger(next());
    BigInteger b = new BigInteger(next());
    BigInteger x = w.min(b).subtract(BigInteger.ONE);
    BigInteger t1 = w.multiply(b).divide(w.gcd(b));
    BigInteger t2 = t.divide(t1);
    BigInteger t3 = t.mod(t1);
    BigInteger t4 = x.add(BigInteger.ONE).multiply(t2).add(x.min(t3));
    BigInteger g = t.gcd(t4);
    BigInteger ooo = t.divide(g);
    BigInteger xxx = t4.divide(g);
    out.println(xxx + "/" + ooo);
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
