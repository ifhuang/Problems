package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class BerSUBall {
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
    Arrays.sort(a);
    line = in.readLine();
    int m = Integer.parseInt(line);
    int[] b = new int[m];
    line = in.readLine();
    part = line.split(" ");
    for (int i = 0; i < m; i++)
      b[i] = Integer.parseInt(part[i]);
    Arrays.sort(b);
    int count = 0;
    for (int i = 0, j = 0; i < n && j < m;)
      if (Math.abs(a[i] - b[j]) <= 1) {
        count++;
        i++;
        j++;
      } else if (a[i] < b[j])
        i++;
      else
        j++;
    out.println(count);
    out.close();
    in.close();
  }
}
