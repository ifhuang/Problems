package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://oj.leetcode.com/problems/anagrams/
public class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
    for (String str : strs) {
      Map<Character, Integer> key = getKey(str);
      if (map.containsKey(key)) {
        map.get(key).add(str);
      } else {
        List<String> list = new ArrayList<>();
        list.add(str);
        map.put(key, list);
      }
    }
    List<List<String>> ans = new ArrayList<>();
    for (Map<Character, Integer> key : map.keySet()) {
      List<String> list = map.get(key);
      Collections.sort(list);
      ans.add(list);
    }
    return ans;
  }

  private Map<Character, Integer> getKey(String str) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : str.toCharArray()) {
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
      }
    }
    return map;
  }
}
