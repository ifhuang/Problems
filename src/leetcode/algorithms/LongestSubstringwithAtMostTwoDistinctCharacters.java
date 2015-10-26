package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
// Given a string, find the length of the longest substring T that contains at most 2 distinct
// characters.
// For example, Given s = ¡°eceba¡±,
// T is "ece" which its length is 3.
public class LongestSubstringwithAtMostTwoDistinctCharacters {
  public int lengthOfLongestSubstringTwoDistinct(String s) {
    int n = s.length();
    int k = 2;
    int ans = 0;
    int i = 0, j = 0;
    Map<Character, Integer> map = new HashMap<>();
    while (j < n) {
      char c = s.charAt(j);
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
        while (map.size() == k) {
          char old = s.charAt(i);
          int count = map.get(old);
          if (count == 1) {
            map.remove(old);
          } else {
            map.put(old, count - 1);
          }
          i++;
        }
        map.put(c, 1);
      }
      ans = Math.max(ans, j - i + 1);
      j++;
    }
    return ans;
  }
}
