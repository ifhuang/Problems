package atcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Playing {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int h = nextInt();
    int w = nextInt();
    char[][] b = new char[h][w];
    for (int i = 0; i < h; i++) {
      b[i] = next().toCharArray();
    }
    Map<Character, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        if (!map.containsKey(b[i][j])) {
          List<Integer> list = new ArrayList<>();
          list.add(i + 1);
          list.add(j + 1);
          map.put(b[i][j], list);
        }
      }
    }
    for (char key : map.keySet()) {
      List<Integer> list = map.get(key);
      out.println(key + " " + list.get(0) + " " + list.get(1));
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
