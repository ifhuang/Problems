package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// http://www.lintcode.com/en/problem/anagrams/
public class Anagrams {
  /**
   * @param strs: A list of strings
   * @return: A list of strings
   */
  public List<String> anagrams(String[] strs) {
    // write your code here
    Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
    for (String s : strs) {
      Map<Character, Integer> key = transform(s);
      if (!map.containsKey(key)) {
        List<String> list = new ArrayList<>();
        map.put(key, list);
      }
      map.get(key).add(s);
    }
    List<String> ans = new ArrayList<>();
    for (Map<Character, Integer> key : map.keySet()) {
      List<String> list = map.get(key);
      if (map.get(key).size() > 1) {
        ans.addAll(list);
      }
    }
    return ans;
  }

  private Map<Character, Integer> transform(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char key = s.charAt(i);
      if (!map.containsKey(key)) {
        map.put(key, 0);
      }
      map.put(key, map.get(key) + 1);
    }
    return map;
  }
}
