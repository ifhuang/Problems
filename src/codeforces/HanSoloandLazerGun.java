package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HanSoloandLazerGun {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line = in.readLine();
    String[] part = line.split(" ");
    int n = Integer.parseInt(part[0]);
    int x0 = Integer.parseInt(part[1]);
    int y0 = Integer.parseInt(part[2]);
    Set<List<Integer>> set = new HashSet<>();
    while (n-- > 0) {
      line = in.readLine();
      part = line.split(" ");
      int xd = Integer.parseInt(part[0]) - x0;
      int yd = Integer.parseInt(part[1]) - y0;
      int d = gcd(xd, yd);
      xd /= d;
      yd /= d;
      List<Integer> list = new ArrayList<>();
      list.add(xd);
      list.add(yd);
      set.add(list);
    }
    out.println(set.size());
    out.close();
    in.close();
  }

  static int gcd(int a, int b) {
    return a == 0 ? b : gcd(b % a, a);
  }
}
