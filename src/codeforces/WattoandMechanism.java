package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WattoandMechanism {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line = in.readLine();
    String[] part = line.split(" ");
    int n = Integer.parseInt(part[0]);
    int m = Integer.parseInt(part[1]);
    Map<List<Integer>, List<String>> map = new HashMap<>();
    while (n-- > 0) {
      line = in.readLine();
      List<Integer> key = composeKey(line);
      if (map.containsKey(key))
        map.get(key).add(line);
      else {
        List<String> list = new ArrayList<>();
        list.add(line);
        map.put(key, list);
      }
    }
    while (m-- > 0) {
      line = in.readLine();
      boolean flag = false;
      for (List<Integer> list : queryKeys(line))
        if (map.containsKey(list))
          for (String s : map.get(list))
            if (check(s, line)) {
              flag = true;
              break;
            }
      if (flag)
        out.println("YES");
      else
        out.println("NO");
    }
    out.close();
    in.close();
  }

  static List<Integer> composeKey(String line) {
    int a = 0;
    int b = 0;
    int c = 0;
    for (int i = 0; i < line.length(); i++) {
      char ch = line.charAt(i);
      if (ch == 'a')
        a++;
      else if (ch == 'b')
        b++;
      else
        c++;
    }
    List<Integer> list = new ArrayList<>();
    list.add(a);
    list.add(b);
    list.add(c);
    return list;
  }

  static List<List<Integer>> queryKeys(String line) {
    List<Integer> list = composeKey(line);
    List<List<Integer>> ans = new ArrayList<>();
    for (int i = -1; i <= 1; i++)
      for (int j = -1; j <= 1; j++)
        for (int k = -1; k <= 1; k++)
          if (i != j && i != k && j != k) {
            List<Integer> item = new ArrayList<>();
            int a = list.get(0) + i;
            int b = list.get(1) + j;
            int c = list.get(2) + k;
            if (a >= 0 && b >= 0 && c >= 0) {
              item.add(a);
              item.add(b);
              item.add(c);
              ans.add(item);
            }
          }
    return ans;
  }

  static boolean check(String s1, String s2) {
    int diff = 0;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i))
        diff++;
      if (diff > 1)
        return false;
    }
    return true;
  }

}
