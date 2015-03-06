package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MUHandHouseofCards {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    long card = Long.parseLong(in.readLine());
    long ans = 0;
    long floor = 1;
    long base = 0;
    while (true) {
      long c = card - 2 * floor - 3 * base;
      if (c < 0)
        break;
      if (c % 3 == 0)
        ans++;
      base += floor;
      floor++;
    }
    out.println(ans);
    out.close();
    in.close();
  }
}
