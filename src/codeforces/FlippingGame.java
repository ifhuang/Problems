package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FlippingGame {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line = in.readLine();
    int n = Integer.parseInt(line);
    int[] a = new int[n];
    line = in.readLine();
    String[] part = line.split(" ");
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(part[i]);
    int x = 0;
    int y = 0;
    int z = 0;
    int maxY = Integer.MIN_VALUE;
    int maxZ = 0;
    for (int i = 0; i < n; i++)
      if (a[i] == 0) {
        y++;
        if (y > maxY) {
          maxY = y;
          maxZ = z;
        }
      } else {
        x++;
        y--;
        z++;
        if (y < 0) {
          y = 0;
          z = 0;
        }
      }
    out.println(x + maxY - maxZ);
    out.close();
    in.close();
  }
}
