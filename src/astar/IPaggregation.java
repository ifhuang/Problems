package astar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class IPaggregation {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int T = nextInt();
    for (int i = 1; i <= T; i++) {
      int N = nextInt(), M = nextInt();
      String[] ip = new String[N];
      String[] net = new String[M];
      for (int j = 0; j < N; j++)
        ip[j] = next();
      for (int j = 0; j < M; j++)
        net[j] = next();
      out.println(String.format("Case #%d:", i));
      for (int j = 0; j < M; j++) {
        Set<String> set = new HashSet<String>();
        for (int k = 0; k < N; k++)
          set.add(code(ip[k], net[j]));
        out.println(set.size());
      }
    }
  }

  static String code(String ip, String net) {
    String[] a = ip.split("\\.");
    String[] b = net.split("\\.");
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < a.length; i++)
      sb.append(Integer.parseInt(a[i]) & Integer.parseInt(b[i])).append(".");
    return sb.substring(0, sb.length() - 1);
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
