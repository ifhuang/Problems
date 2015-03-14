package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class DreamoonandWiFi {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line = in.readLine();
    int p = 0;
    int n = 0;
    for (int i = 0; i < line.length(); i++)
      if (line.charAt(i) == '+')
        p++;
      else
        n++;
    line = in.readLine();
    int p1 = 0;
    int n1 = 0;
    int m = 0;
    for (int i = 0; i < line.length(); i++)
      if (line.charAt(i) == '+')
        p1++;
      else if (line.charAt(i) == '-')
        n1++;
      else
        m++;
    if (p1 > p || n1 > n)
      out.println(0.000000000000);
    else
      out.println(c(p - p1, m) / Math.pow(2, m));
    out.close();
    in.close();
  }

  static int c(int a, int b) {
    int diff = b - a;
    if (diff < a)
      return c(diff, b);
    int up = 1;
    for (int i = b - a + 1; i <= b; i++)
      up *= i;
    int down = 1;
    for (int i = 2; i <= a; i++)
      down *= i;
    return up / down;
  }
}
