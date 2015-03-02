package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class Pangram {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    int n = Integer.parseInt(in.readLine());
    boolean flag = false;
    if (n >= 26) {
      Set<Character> set = new HashSet<>();
      String line = in.readLine().toLowerCase();
      for (int i = 0; i < line.length(); i++)
        set.add(line.charAt(i));
      if (set.size() == 26)
        flag = true;
    }
    if (flag)
      out.println("YES");
    else
      out.println("NO");
    out.close();
    in.close();
  }
}
