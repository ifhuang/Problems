package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class TheUnionofkSegments {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt(), k = nextInt();
    List<PairS> segments = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      segments.add(new PairS(nextInt(), -1));
      segments.add(new PairS(nextInt(), 1));
    }
    Collections.sort(segments, new Comparator<PairS>() {
      @Override
      public int compare(PairS o1, PairS o2) {
        return o1.a == o2.a ? o1.b - o2.b : o1.a - o2.a;
      }
    });
    int count = 0;
    int left = 0;
    int right = 0;
    List<PairS> ans = new ArrayList<>();
    for (PairS segment : segments) {
      if (count == k - 1 && segment.b == -1) {
        left = segment.a;
      } else if (count == k && segment.b == 1) {
        right = segment.a;
        ans.add(new PairS(left, right));
      }
      count -= segment.b;
    }
    out.println(ans.size());
    for (PairS pair : ans) {
      out.println(pair.a + " " + pair.b);
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


class PairS {
  int a, b;

  PairS(int a, int b) {
    this.a = a;
    this.b = b;
  }

}
