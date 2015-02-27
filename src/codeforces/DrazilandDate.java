package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class DrazilandDate {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line = in.readLine();
    String[] part = line.split(" ");
    int a = Integer.parseInt(part[0]);
    int b = Integer.parseInt(part[1]);
    int s = Integer.parseInt(part[2]);
    int diff = s - (Math.abs(a) + Math.abs(b));
    if (diff < 0 || diff % 2 != 0)
      out.println("NO");
    else
      out.println("YES");
    out.close();
    in.close();
  }
}
