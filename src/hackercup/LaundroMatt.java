package hackercup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class LaundroMatt {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int T = nextInt();
    for (int t = 1; t <= T; t++) {
      int L = nextInt();
      int N = nextInt();
      long M = nextLong();
      long D = nextLong();
      long[] W = nextLongArray(N, 0);
      PriorityQueue<WashMachine> washPQ = new PriorityQueue<>();
      for (int i = 0; i < N; i++) {
        washPQ.offer(new WashMachine(W[i], i));
      }
      List<Long> washDoneTimes = new ArrayList<>();
      for (int i = 0; i < L; i++) {
        WashMachine wm = washPQ.poll();
        washDoneTimes.add(wm.time);
        wm.time += W[wm.index];
        washPQ.offer(wm);
      }
      PriorityQueue<Long> dryPQ = new PriorityQueue<>();
      for (long washDoneTime : washDoneTimes) {
        while (!dryPQ.isEmpty()) {
          long first = dryPQ.peek();
          if (first <= washDoneTime) {
            dryPQ.poll();
          } else {
            break;
          }
        }
        if (dryPQ.size() < M) {
          dryPQ.offer(washDoneTime + D);
        } else {
          long dryDoneTime = dryPQ.poll();
          dryDoneTime += D;
          dryPQ.offer(dryDoneTime);
        }
      }
      long ans = 0;
      for (long dryDoneTime : dryPQ) {
        ans = Math.max(ans, dryDoneTime);
      }
      out.println(String.format("Case #%d: %d", t, ans));
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


class WashMachine implements Comparable<WashMachine> {
  long time;
  int index;

  WashMachine(long time, int index) {
    this.time = time;
    this.index = index;
  }

  @Override
  public int compareTo(WashMachine o) {
    return Long.compare(time, o.time);
  }
}
