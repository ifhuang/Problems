package hackercup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CodingContestCreation {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int T = nextInt();
    for (int t = 1; t <= T; t++) {
      int N = nextInt();
      int[] D = nextIntArray(N, 0);
      int pre = 0;
      int cur = 0;
      int i = 0;
      while (i < N) {
        // begin
        if (cur % 4 == 0) {
          int insert = Math.max(D[i] - 97, 0);
          cur += insert + 1;
          pre = D[i];
          i++;
        } else {
          int diff = D[i] - pre;
          if (diff <= 0) {
            int append = 4 - cur % 4;
            cur += append;
            pre += append;
          } else if (diff <= 10) {
            cur++;
            pre = D[i];
            i++;
          } else {
            cur++;
            pre += 10;
          }
        }
      }
      if (cur % 4 != 0) {
        int append = 4 - cur % 4;
        cur += append;
      }
      out.println(String.format("Case #%d: %d", t, cur - N));
    }
  }

  public static void main(String args[]) {
    try {
      in = new BufferedReader(new InputStreamReader(System.in));
      // in = new BufferedReader(new FileReader(args[0]));
      out = new PrintWriter(new OutputStreamWriter(System.out));
      // out = new PrintWriter(args[1]);
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
