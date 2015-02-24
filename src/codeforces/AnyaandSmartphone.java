package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class AnyaandSmartphone {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line = in.readLine();
    String[] part = line.split(" ");
    int n = Integer.parseInt(part[0]);
    int m = Integer.parseInt(part[1]);
    int k = Integer.parseInt(part[2]);
    line = in.readLine();
    part = line.split(" ");
    Map<Integer, Integer> map1 = new HashMap<>();
    Map<Integer, Integer> map2 = new HashMap<>();
    for (int i = 0; i < n; i++) {
      map1.put(Integer.parseInt(part[i]), i);
      map2.put(i, Integer.parseInt(part[i]));
    }
    line = in.readLine();
    part = line.split(" ");
    int[] launch = new int[m];
    for (int i = 0; i < m; i++)
      launch[i] = Integer.parseInt(part[i]);
    long ans = 0;
    for (int i = 0; i < m; i++) {
      ans++;
      int x = map1.get(launch[i]);
      if (x > 0) {
        ans += x / k;
        int pre = map2.get(x - 1);
        map1.put(launch[i], x - 1);
        map2.put(x - 1, launch[i]);
        map1.put(pre, x);
        map2.put(x, pre);
      }
    }
    out.println(ans);
    out.close();
    in.close();
  }
}
