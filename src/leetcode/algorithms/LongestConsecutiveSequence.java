package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

// https://oj.leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSequence {
  public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    int ans = 0;
    for (int num : nums) {
      if (set.contains(num)) {
        set.remove(num);
        int i = num + 1;
        while (set.contains(i)) {
          set.remove(i);
          i++;
        }
        int j = num - 1;
        while (set.contains(j)) {
          set.remove(j);
          j--;
        }
        ans = Math.max(ans, i - j - 1);
      }
    }
    return ans;
  }
}
