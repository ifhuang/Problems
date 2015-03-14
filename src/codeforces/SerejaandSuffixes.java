package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class SerejaandSuffixes {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line = in.readLine();
    String[] part = line.split(" ");
    int n = Integer.parseInt(part[0]);
    int m = Integer.parseInt(part[1]);
    Set<Integer> set = new HashSet<>();
    int[] count = new int[n + 1];
    line = in.readLine();
    part = line.split(" ");
    for (int i = n - 1; i >= 0; i--) {
      count[i] = count[i + 1];
      if (set.add(Integer.parseInt(part[i])))
        count[i]++;
    }
    while (m-- > 0)
      out.println(count[Integer.parseInt(line = in.readLine()) - 1]);
    out.close();
    in.close();
  }
}
