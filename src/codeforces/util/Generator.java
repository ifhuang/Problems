package codeforces.util;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Generator {

  static PrintWriter out;

  static void generate() throws Exception {
    int n = 500;
    int m = 500;
    int r1 = 1, c1 = 1, r2 = 500, c2 = 500;
    char[][] c = new char[n][m];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        c[i][j] = '.';
    out.println(n + " " + m);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++)
        out.print(c[i][j]);
      out.println();
    }
    out.println(r1 + " " + c1);
    out.println(r2 + " " + c2);
  }

  public static void main(String args[]) {
    try {
      out = new PrintWriter(new OutputStreamWriter(new FileOutputStream("output.out")));
      generate();
      out.close();
    } catch (Throwable e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

}
