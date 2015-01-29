package codejam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sortascrambleditinerary {
  static int num;
  static Map<String, String> fromToMap;
  static Map<String, String> toFromMap;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    int k = 1;
    while (T-- > 0) {
      num = scanner.nextInt();
      fromToMap = new HashMap<>();
      toFromMap = new HashMap<>();
      scanner.nextLine();
      for (int i = 0; i < num; i++) {
        String from = scanner.nextLine();
        String to = scanner.nextLine();
        fromToMap.put(from, to);
        toFromMap.put(to, from);
      }
      System.out.print(String.format("Case #%d:", k++));
      String start = "";
      for (String key : fromToMap.keySet())
        if (!toFromMap.containsKey(key)) {
          start = key;
          break;
        }
      while (!fromToMap.isEmpty()) {
        String to = fromToMap.remove(start);
        System.out.print(String.format(" %s-%s", start, to));
        start = to;
      }
      System.out.println();
    }
    scanner.close();
  }
}
