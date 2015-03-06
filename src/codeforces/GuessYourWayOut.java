package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class GuessYourWayOut {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String[] part = in.readLine().split(" ");
    long h = Long.parseLong(part[0]);
    long n = Long.parseLong(part[1]);
    out.println(count(h, n, true));
    out.close();
    in.close();
  }

  static long count(long h, long n, boolean left) {
    if (h == 1) {
      if (n == 1 && left || n == 2 && !left)
        return 1;
      else
        return 2;
    }
    long leaf = (long) Math.pow(2, h);
    if (n <= leaf / 2) {
      long t = count(h - 1, n, false);
      if (!left)
        t += (long) (Math.pow(2, h + 1) - 2) / 2;
      return t + 1;
    } else {
      n -= leaf / 2;
      long t = count(h - 1, n, true);
      if (left)
        t += (long) (Math.pow(2, h + 1) - 2) / 2;
      return t + 1;
    }
  }
}
