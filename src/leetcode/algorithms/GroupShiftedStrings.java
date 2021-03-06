package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/group-shifted-strings/
// Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" ->
// "bcd". We can keep "shifting" which forms the sequence:
// "abc" -> "bcd" -> ... -> "xyz"
// Given a list of strings which contains only lowercase alphabets, group all strings that belong to
// the same shifting sequence.
// For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
// Return:
// [
// ["abc","bcd","xyz"],
// ["az","ba"],
// ["acef"],
// ["a","z"]
// ]
// Note: For the return value, each inner list's elements must follow the lexicographic order.
public class GroupShiftedStrings {
  public List<List<String>> groupStrings(String[] strings) {
    List<List<String>> result = new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strings) {
      int offset = str.charAt(0) - 'a';
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < str.length(); i++) {
        char c = (char) (str.charAt(i) - offset);
        if (c < 'a') {
          c += 26;
        }
        sb.append(c);
      }
      String key = sb.toString();
      if (!map.containsKey(key)) {
        List<String> list = new ArrayList<>();
        map.put(key, list);
      }
      map.get(key).add(str);
    }
    for (String key : map.keySet()) {
      List<String> list = map.get(key);
      Collections.sort(list);
      result.add(list);
    }
    return result;
  }
}
