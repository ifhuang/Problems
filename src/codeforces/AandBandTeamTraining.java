package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class AandBandTeamTraining {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line = in.readLine();
    String[] part = line.split(" ");
    int n = Integer.parseInt(part[0]);
    int m = Integer.parseInt(part[1]);
    int a = Math.min(n, m / 2);
    int ans = a;
    int x = n - a;
    int y = m - 2 * a;
    for (int i = 0; i < a; i++) {
      int newX = x + i;
      int newY = y + 2 * i;
      ans = Math.max(ans, a - i + Math.min(newX / 2, newY));
    }
    int b = Math.min(n / 2, m);
    x = n - 2 * b;
    y = m - b;
    for (int i = 0; i < b; i++) {
      int newX = x + 2 * i;
      int newY = y + i;
      ans = Math.max(ans, b - i + Math.min(newX, newY / 2));
    }
    out.println(ans);
    out.close();
    in.close();
  }
}
