package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TwoButtons {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line = in.readLine();
    String[] part = line.split(" ");
    int n = Integer.parseInt(part[0]);
    int m = Integer.parseInt(part[1]);
    int ans = 0;
    while (n < m) {
      if (m % 2 == 1) {
        m++;
        ans++;
      }
      m /= 2;
      ans++;
      if (m <= n)
        break;
    }
    ans += n - m;
    out.println(ans);
    out.close();
    in.close();
  }
}
