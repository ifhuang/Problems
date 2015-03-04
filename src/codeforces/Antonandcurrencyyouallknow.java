package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Antonandcurrencyyouallknow {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line = in.readLine();
    StringBuilder sb = new StringBuilder(line);
    int len = line.length();
    int last = line.charAt(len - 1) - '0';
    int index = -1;
    for (int i = 0; i < len - 1; i++) {
      int num = line.charAt(i) - '0';
      if (num % 2 == 0) {
        index = i;
        if (num < last)
          break;
      }
    }
    if (index == -1)
      out.println(-1);
    else {
      char c = line.charAt(index);
      char l = line.charAt(len - 1);
      sb.setCharAt(index, l);
      sb.setCharAt(len - 1, c);
      out.println(sb);
    }
    out.close();
    in.close();
  }
}
