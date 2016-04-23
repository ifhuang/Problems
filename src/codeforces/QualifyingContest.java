package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class QualifyingContest {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt();
    int m = nextInt();
    List<List<Participant>> list = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      list.add(new ArrayList<>());
    }
    for (int i = 0; i < n; i++) {
      String a = next();
      int b = nextInt() - 1;
      int c = nextInt();
      list.get(b).add(new Participant(a, c));
    }
    for (int i = 0; i < m; i++) {
      List<Participant> each = list.get(i);
      Collections.sort(each);
      if (each.size() > 2 && each.get(1).c == each.get(2).c) {
        out.println("?");
      } else {
        out.println(each.get(0).a + " " + each.get(1).a);
      }
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


class Participant implements Comparable<Participant> {
  String a;
  int c;

  Participant(String a, int c) {
    this.a = a;
    this.c = c;
  }

  @Override
  public int compareTo(Participant o) {
    return o.c - c;
  }
}
