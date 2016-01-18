package hackercup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Yachtzee {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int T = nextInt();
    for (int t = 1; t <= T; t++) {
      int N = nextInt();
      long A = nextLong();
      long B = nextLong();
      long[] C = nextLongArray(N, 0);
      long sum = 0;
      double avg = 0.0;
      for (long c : C) {
        sum += c;
        double copy = c;
        avg += copy / 2 * copy;
      }
      avg /= sum;
      // head
      long headTmp = 0;
      long a = A % sum;
      double headAvg = 0.0;
      long headSum = 0;
      for (int i = 0; i < N; i++) {
        long tmp = headTmp + C[i];
        double copy = C[i];
        if (tmp > a) {
          if (headTmp > a) {
            headAvg += copy / 2 * copy;
            headSum += C[i];
          } else {
            headAvg += (copy + (a - headTmp)) / 2 * (copy - (a - headTmp));
            headSum += C[i] - (a - headTmp);
          }
        }
        headTmp = tmp;
      }
      headAvg = headSum == 0 ? 0.0 : headAvg / headSum;
      // middle
      double middleAvg = avg;
      long middleSum = (B - A) / sum * sum;
      // tail
      long tailTmp = 0;
      long b = B % sum;
      double tailAvg = 0.0;
      long tailSum = 0;
      for (int i = 0; i < N; i++) {
        long tmp = tailTmp + C[i];
        double copy = C[i];
        if (tailTmp < b) {
          if (tmp < b) {
            tailAvg += copy / 2 * copy;
            tailSum += C[i];
          } else {
            tailAvg += (double) (b - tailTmp) / 2 * (b - tailTmp);
            tailSum += b - tailTmp;
          }
        } else {
          break;
        }
        tailTmp = tmp;
      }
      tailAvg = tailSum == 0 ? 0.0 : tailAvg / tailSum;
      double ans;
      if (middleSum == 0) {
        if (a < b) {
          ans = headAvg * headSum + tailAvg * tailSum - middleAvg * sum;
          ans /= (headSum + tailSum - sum);
        } else {
          ans = headAvg * headSum + tailAvg * tailSum;
          ans /= (headSum + tailSum);
        }
      } else {
        if (a < b) {
          ans = headAvg * headSum + tailAvg * tailSum + middleAvg * middleSum - middleAvg * sum;
          ans /= (headSum + tailSum + middleSum - sum);
        } else {
          ans = headAvg * headSum + tailAvg * tailSum + middleAvg * middleSum;
          ans /= (headSum + tailSum + middleSum);
        }
      }
      out.println(String.format("Case #%d: %.9f", t, ans));
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
