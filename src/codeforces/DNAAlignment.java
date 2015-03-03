package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class DNAAlignment {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    int n = Integer.parseInt(in.readLine());
    String line = in.readLine();
    int[] count = new int[4];
    for (int i = 0; i < n; i++)
      count["ATCG".indexOf(line.charAt(i))]++;
    int max = 0;
    for (int i = 0; i < 4; i++)
      max = Math.max(max, count[i]);
    int maxCount = 0;
    for (int i = 0; i < 4; i++)
      if (count[i] == max)
        maxCount++;
    long ans = 1;
    for (int i = 0; i < n; i++)
      ans = ans * maxCount % (1000000007);
    out.println(ans);
    out.close();
    in.close();
  }
}
