package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MUHandImportantThings {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    in.readLine();
    boolean flag = false;
    int count = 0;
    Map<Integer, List<Integer>> map = new TreeMap<>();
    String[] part = in.readLine().split(" ");
    for (int i = 0; i < part.length; i++) {
      int num = Integer.parseInt(part[i]);
      if (map.containsKey(num)) {
        List<Integer> list = map.get(num);
        list.add(i + 1);
        if (list.size() >= 3)
          flag = true;
        count++;
      } else {
        List<Integer> list = new ArrayList<>();
        list.add(i + 1);
        map.put(num, list);
      }
    }
    if (!flag && count < 2) {
      out.println("NO");
    } else {
      out.println("YES");
      List<StringBuilder> ans = new ArrayList<>();
      ans.add(new StringBuilder());
      ans.add(new StringBuilder());
      ans.add(new StringBuilder());
      if (flag) {
        for (int k : map.keySet()) {
          List<Integer> list = map.get(k);
          if (list.size() >= 3 && flag) {
            ans.get(0).append(list.get(0)).append(' ');
            ans.get(0).append(list.get(1)).append(' ');
            ans.get(0).append(list.get(2)).append(' ');
            ans.get(1).append(list.get(1)).append(' ');
            ans.get(1).append(list.get(0)).append(' ');
            ans.get(1).append(list.get(2)).append(' ');
            ans.get(2).append(list.get(2)).append(' ');
            ans.get(2).append(list.get(0)).append(' ');
            ans.get(2).append(list.get(1)).append(' ');
            for (int i = 3; i < list.size(); i++) {
              ans.get(0).append(list.get(i)).append(' ');
              ans.get(1).append(list.get(i)).append(' ');
              ans.get(2).append(list.get(i)).append(' ');
            }
            flag = false;
          } else {
            for (int i = 0; i < list.size(); i++) {
              ans.get(0).append(list.get(i)).append(' ');
              ans.get(1).append(list.get(i)).append(' ');
              ans.get(2).append(list.get(i)).append(' ');
            }
          }
        }
      } else {
        int time = 0;
        for (int k : map.keySet()) {
          List<Integer> list = map.get(k);
          if (time < 2 && list.size() == 2) {
            if (time == 0) {
              ans.get(0).append(list.get(0)).append(' ');
              ans.get(1).append(list.get(0)).append(' ');
              ans.get(2).append(list.get(1)).append(' ');
              ans.get(0).append(list.get(1)).append(' ');
              ans.get(1).append(list.get(1)).append(' ');
              ans.get(2).append(list.get(0)).append(' ');
            } else {
              ans.get(0).append(list.get(0)).append(' ');
              ans.get(1).append(list.get(1)).append(' ');
              ans.get(2).append(list.get(0)).append(' ');
              ans.get(0).append(list.get(1)).append(' ');
              ans.get(1).append(list.get(0)).append(' ');
              ans.get(2).append(list.get(1)).append(' ');
            }
            time++;
          } else {
            for (int i = 0; i < list.size(); i++) {
              ans.get(0).append(list.get(i)).append(' ');
              ans.get(1).append(list.get(i)).append(' ');
              ans.get(2).append(list.get(i)).append(' ');
            }
          }
        }
      }
      for (StringBuilder sb : ans)
        out.println(sb);
    }
    out.close();
    in.close();
  }
}
