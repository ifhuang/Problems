package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class GlassCarving {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int w = nextInt(), h = nextInt(), n = nextInt();
    TreeSet<Integer> ws = new TreeSet<>();
    ws.add(0);
    ws.add(w);
    TreeSet<Integer> hs = new TreeSet<>();
    hs.add(0);
    hs.add(h);
    int max = 200000;
    int[] wl = new int[max + 1];
    wl[w]++;
    int[] hl = new int[max + 1];
    hl[h]++;
    int wi = w;
    int hi = h;
    for (int i = 0; i < n; i++) {
      String s = next();
      int j = nextInt();
      if (s.equals("V")) {
        if (!ws.contains(j)) {
          ws.add(j);
          int higher = ws.higher(j);
          int lower = ws.lower(j);
          wl[higher - lower]--;
          wl[higher - j]++;
          wl[j - lower]++;
        }
      } else {
        if (!hs.contains(j)) {
          hs.add(j);
          int higher = hs.higher(j);
          int lower = hs.lower(j);
          hl[higher - lower]--;
          hl[higher - j]++;
          hl[j - lower]++;
        }
      }
      while (wl[wi] == 0)
        wi--;
      while (hl[hi] == 0)
        hi--;
      out.println((long) wi * hi);
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
