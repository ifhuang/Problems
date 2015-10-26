package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum-iii-data-structure-design/
// Design and implement a TwoSum class. It should support the following operations: add and find.
// add - Add the number to an internal data structure.
// find - Find if there exists any pair of numbers which sum is equal to the value.
// For example,
// add(1); add(3); add(5);
// find(4) -> true
// find(7) -> false
public class TwoSumIIIDatastructuredesign {
  private Map<Integer, Integer> map = new HashMap<>();

  // Add the number to an internal data structure.
  public void add(int number) {
    map.put(number, map.containsKey(number) ? map.get(number) + 1 : 1);
  }

  // Find if there exists any pair of numbers which sum is equal to the value.
  public boolean find(int value) {
    for (int key : map.keySet()) {
      int diff = value - key;
      if ((diff == key && map.get(key) > 1) || (diff != key && map.containsKey(diff))) {
        return true;
      }
    }
    return false;
  }
}
