package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Chewba§ãcaandNumber {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line = in.readLine();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < line.length(); i++) {
      char c = line.charAt(i);
      if (i == 0 && c == '9' || c < '5')
        sb.append(c);
      else
        sb.append(9 - (c - '0'));
    }
    out.println(sb.toString());
    out.close();
    in.close();
  }
}
