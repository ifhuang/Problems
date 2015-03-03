package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FoxAndSnake {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line = in.readLine();
    String[] part = line.split(" ");
    int n = Integer.parseInt(part[0]);
    int m = Integer.parseInt(part[1]);
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      if (i % 2 == 1)
        for (int j = 1; j <= m; j++)
          sb.append('#');
      else if (i / 2 % 2 == 1) {
        for (int j = 1; j < m; j++)
          sb.append('.');
        sb.append('#');
      } else {
        sb.append('#');
        for (int j = 1; j < m; j++)
          sb.append('.');
      }
      sb.append('\n');
    }
    out.println(sb);
    out.close();
    in.close();
  }
}
