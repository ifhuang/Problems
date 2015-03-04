package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class AnyaandGhosts {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String[] part = in.readLine().split(" ");
    int t = Integer.parseInt(part[1]);
    int r = Integer.parseInt(part[2]);
    int base = 1000;
    boolean[] candles = new boolean[2000];
    int[] lights = new int[2000];
    for (String gost : in.readLine().split(" ")) {
      int g = Integer.parseInt(gost) + base;
      while (lights[g] < r) {
        int p = g - 1;
        while (candles[p])
          p--;
        if (p + 1 + t < g) {
          out.println(-1);
          out.close();
          System.exit(0);
        }
        candles[p] = true;
        light(lights, p, t);
      }
    }
    int count = 0;
    for (boolean c : candles)
      if (c)
        count++;
    out.println(count);
    out.close();
    in.close();
  }

  static void light(int[] lights, int light, int t) {
    for (int i = light + 1; i <= light + t; i++)
      lights[i]++;
  }
}
