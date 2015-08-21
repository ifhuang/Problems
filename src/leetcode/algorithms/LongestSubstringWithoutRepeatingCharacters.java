package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

// https://oj.leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharacters {
  // time O(n), space O(1)
  public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int ans = 0;
    for (int i = 0, j = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (map.containsKey(c))
        j = Math.max(j, map.get(c) + 1);
      ans = Math.max(ans, i - j + 1);
      map.put(c, i);
    }
    return ans;
  }
}
