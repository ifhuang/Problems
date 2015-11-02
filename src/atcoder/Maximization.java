package atcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Maximization {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int h = nextInt();
    int w = nextInt();
    int x = nextInt();
    int k = nextInt();
    int[][] c = new int[h][w];
    for (int i = 0; i < h; i++) {
      c[i] = nextIntArray(w, 0);
    }
    while (k-- > 0) {
      int[] sum = new int[h + w];
      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          sum[i] += c[i][j];
          sum[h + j] += c[i][j];
        }
      }
      int max = Integer.MIN_VALUE;
      int maxIndex = -1;
      for (int i = 0; i < h + w; i++) {
        int val = 0;
        if (i < h) {
          val = x * w - sum[i];
        } else {
          val = x * h - sum[i];
        }
        if (val > max) {
          max = val;
          maxIndex = i;
        }
      }
      if (max <= 0) {
        break;
      }
      if (maxIndex < h) {
        for (int i = 0; i < w; i++) {
          c[maxIndex][i] = x;
        }
      } else {
        for (int i = 0; i < h; i++) {
          c[i][maxIndex - h] = x;
        }
      }
    }
    int ans = 0;
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        ans += c[i][j];
      }
    }
    out.println(ans);
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
