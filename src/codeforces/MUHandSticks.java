package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MUHandSticks {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line = in.readLine();
    String[] part = line.split(" ");
    Map<Integer, Integer> map = new ConcurrentHashMap<>();
    for (String s : part) {
      int i = Integer.parseInt(s);
      if (map.containsKey(i))
        map.put(i, map.get(i) + 1);
      else
        map.put(i, 1);
    }
    boolean flag = false;
    for (int i : map.keySet()) {
      if (map.get(i) == 4) {
        map.remove(i);
        flag = true;
      } else if (map.get(i) > 4) {
        map.put(i, map.get(i) - 4);
        flag = true;
      }
    }
    if (!flag) {
      out.println("Alien");
    } else {
      if (map.size() == 2)
        out.println("Bear");
      else
        out.println("Elephant");
    }
    out.close();
    in.close();
  }
}
