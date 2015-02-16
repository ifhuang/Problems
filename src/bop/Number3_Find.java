package bop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Number3_Find {
  public int find(int[] id) {
    int now = id[0];
    int count = 1;
    for (int i = 1; i < id.length; i++)
      if (count == 0) {
        now = id[i];
        count++;
      } else if (now != id[i])
        count--;
      else
        count++;
    return now;
  }

  public Integer[] findN(int[] id, int n) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < id.length; i++) {
      if (map.containsKey(id[i]))
        map.put(id[i], map.get(id[i]) + 1);
      else if (map.size() < n - 1)
        map.put(id[i], 1);
      else {
        for (int key : map.keySet())
          if (map.get(key) > 1)
            map.put(key, map.get(key) - 1);
          else
            map.remove(key);
      }
    }
    return map.keySet().toArray(new Integer[0]);
  }

  public static void main(String[] args) {
    Number3_Find n3 = new Number3_Find();
    int[] id = new int[] {1, 1, 2, 2, 2, 2, 5, 5, 5, 1, 1, 1, 1, 1, 1};
    System.out.println(n3.find(id));
    int[] idN = new int[] {1, 1, 1, 1, 2, 2, 2, 2, 5};
    System.out.println(Arrays.toString(n3.findN(idN, 3)));
  }
}
