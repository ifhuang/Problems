package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Random;
import java.util.StringTokenizer;

public class Flowers {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int t = nextInt();
    int k = nextInt();
    long MOD = 1000000007;
    int max = 100001;
    long[] dp = new long[max];
    dp[0] = 1;
    for (int i = 1; i < max; i++) {
      dp[i] = dp[i - 1];
      if (i >= k)
        dp[i] = (dp[i] + dp[i - k]) % MOD;
    }
    for (int i = 1; i < max; i++)
      dp[i] = (dp[i] + dp[i - 1]) % MOD;
    while (t-- > 0) {
      int a = nextInt();
      int b = nextInt();
      out.println((dp[b] - dp[a - 1] + MOD) % MOD);
    }
  }

  public static void main(String args[]) {
    try {
      in = new BufferedReader(new InputStreamReader(System.in));
      out = new PrintWriter(new OutputStreamWriter(System.out));
      // in = new BufferedReader(new FileReader("input.in"));
      // out = new PrintWriter(new FileWriter("output.out"));
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

  static void shuffleArray(long[] array) {
    Random random = new Random();
    for (int i = array.length - 1; i > 0; i--) {
      int index = random.nextInt(i + 1);
      long temp = array[index];
      array[index] = array[i];
      array[i] = temp;
    }
  }

}
