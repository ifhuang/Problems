package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Watermelon {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    int n = Integer.parseInt(in.readLine());
    if (n % 2 == 0 && n != 2)
      out.println("YES");
    else
      out.println("NO");
    out.close();
    in.close();
  }
}
