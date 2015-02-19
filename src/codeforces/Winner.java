package codeforces;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Winner {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    PrintStream ps = new PrintStream(System.out);
    int n = scanner.nextInt();
    scanner.nextLine();
    Map<String, Map<Integer, Integer>> map = new HashMap<>();
    int r = 0;
    while (r++ < n) {
      String[] part = scanner.nextLine().split(" ");
      String name = part[0];
      int score = Integer.parseInt(part[1]);
      if (map.containsKey(name))
        map.get(name).put(r, score);
      else {
        Map<Integer, Integer> mapi = new LinkedHashMap<>();
        mapi.put(r, score);
        map.put(name, mapi);
      }
    }
    String maxName = null;
    int maxScore = 0;
    int first = Integer.MAX_VALUE;
    for (String name : map.keySet()) {
      Map<Integer, Integer> mapi = map.get(name);
      int score = 0;
      for (int row : mapi.keySet())
        score += mapi.get(row);
      if (score >= maxScore) {
        int tmp = 0;
        for (int row : mapi.keySet()) {
          tmp += mapi.get(row);
          if (tmp >= score && row < first) {
            maxName = name;
            maxScore = score;
            first = row;
          }
        }
      }
    }
    ps.println(maxName);
    ps.close();
    scanner.close();
  }
}
