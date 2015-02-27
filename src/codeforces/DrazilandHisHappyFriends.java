package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class DrazilandHisHappyFriends {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line = in.readLine();
    String[] part = line.split(" ");
    int n = Integer.parseInt(part[0]);
    int m = Integer.parseInt(part[1]);
    int len = n * m / gcd(n, m);
    boolean[] an = new boolean[n];
    line = in.readLine();
    part = line.split(" ");
    for (int i = 1; i < part.length; i++)
      an[Integer.parseInt(part[i])] = true;
    boolean[] bm = new boolean[m];
    line = in.readLine();
    part = line.split(" ");
    for (int i = 1; i < part.length; i++)
      bm[Integer.parseInt(part[i])] = true;
    for (int i = 0; i < len; i++)
      an[i % n] = bm[i % m] = an[i % n] || bm[i % m];
    int i = 0;
    for (; i < len; i++)
      if (!an[i % n] && !bm[i % m])
        break;
    if (i == len)
      out.println("YES");
    else
      out.print("NO");
    out.close();
    in.close();
  }

  static int gcd(int a, int b) {
    return a == 0 ? b : gcd(b % a, a);
  }
}
