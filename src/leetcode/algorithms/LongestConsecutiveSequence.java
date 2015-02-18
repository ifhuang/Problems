package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

// https://oj.leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSequence {
  public int longestConsecutive(int[] num) {
    int ans = 0;
    Set<Integer> set = new HashSet<>();
    for (int i : num)
      set.add(i);
    for (int i : num)
      if (set.contains(i)) {
        set.remove(i);
        int len = 1;
        int pre = i - 1;
        while (set.contains(pre)) {
          set.remove(pre);
          pre--;
          len++;
        }
        int post = i + 1;
        while (set.contains(post)) {
          set.remove(post);
          post++;
          len++;
        }
        ans = Math.max(ans, len);
      }
    return ans;
  }
}
