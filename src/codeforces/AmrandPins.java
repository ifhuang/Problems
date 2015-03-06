package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class AmrandPins {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String[] part = in.readLine().split(" ");
    long r = Integer.parseInt(part[0]);
    long x = Integer.parseInt(part[1]);
    long y = Integer.parseInt(part[2]);
    long x1 = Integer.parseInt(part[3]);
    long y1 = Integer.parseInt(part[4]);
    if (x == x1 && y == y1)
      out.println(0);
    else {
      double d = Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1));
      long ans = (long) (Math.ceil(d / (2 * r)));
      out.println(ans);
    }
    out.close();
    in.close();
  }
}
