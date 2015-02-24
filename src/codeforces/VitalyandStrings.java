package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class VitalyandStrings {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String s = in.readLine();
    String t = in.readLine();
    int n = s.length();
    StringBuilder sb = new StringBuilder();
    int flag = 1;
    for (int i = n - 1; i >= 0; i--)
      if (flag == 0)
        sb.append(s.charAt(i));
      else {
        int num = s.charAt(i) - 'a' + flag;
        flag = num / 26;
        char c = (char) ('a' + num % 26);
        sb.append(c);
      }
    String s1 = sb.reverse().toString();
    if (s1.equals(t))
      out.println("No such string");
    else
      out.print(s1);
    out.close();
    in.close();
  }
}
