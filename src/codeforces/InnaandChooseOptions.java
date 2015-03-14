package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class InnaandChooseOptions {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line = in.readLine();
    int n = Integer.parseInt(line);
    int[] a = {1, 2, 3, 4, 6, 12};
    int[] b = {12, 6, 4, 3, 2, 1};
    while (n-- > 0) {
      line = in.readLine();
      int count = 0;
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < a.length; i++) {
        for (int j = 0; j < b[i]; j++) {
          char c = 'X';
          int k = 0;
          for (; k < a[i]; k++)
            if (line.charAt(j + k * b[i]) != c)
              break;
          if (k == a[i]) {
            count++;
            sb.append(a[i] + "x" + b[i] + " ");
            break;
          }
        }
      }
      out.println(count + " " + sb.toString());
    }
    out.close();
    in.close();
  }
}
