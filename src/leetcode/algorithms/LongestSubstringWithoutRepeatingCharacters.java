package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

// https://oj.leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharacters {
  public int lengthOfLongestSubstring(String s) {
    int max = 0;
    int length = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      length++;
      char c = s.charAt(i);
      if (map.containsKey(c))
        length = Math.min(length, i - map.get(c));
      max = Math.max(max, length);
      map.put(c, i);
    }
    return max;
  }
}
