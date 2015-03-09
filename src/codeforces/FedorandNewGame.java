package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FedorandNewGame {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line = in.readLine();
    String[] part = line.split(" ");
    int n = Integer.parseInt(part[0]);
    int m = Integer.parseInt(part[1]);
    int k = Integer.parseInt(part[2]);
    int[] p = new int[m + 1];
    for (int i = 0; i < m + 1; i++)
      p[i] = Integer.parseInt(in.readLine());
    int count = 0;
    for (int i = 0; i < m; i++)
      if (check(p[i], p[m], n, k))
        count++;
    out.println(count);
    out.close();
    in.close();
  }

  static boolean check(int a, int b, int n, int k) {
    int count = 0;
    for (int i = 0; i < n; i++) {
      int mask = 1 << i;
      if ((a & mask) != (b & mask))
        count++;
    }
    return count <= k;
  }
}
