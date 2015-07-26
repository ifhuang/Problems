package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ContainsDuplicateIII {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    int n = nums.length;
    TreeSet<Integer> treeSet = new TreeSet<>();
    for (int i = 0; i < n; i++) {
      Integer floor = treeSet.floor(nums[i] + t);
      Integer ceiling = treeSet.ceiling(nums[i] - t);
      if (floor != null && floor >= nums[i] || ceiling != null && ceiling <= nums[i])
        return true;
      treeSet.add(nums[i]);
      if (i >= k)
        treeSet.remove(nums[i - k]);
    }
    return false;
  }

  public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
    if (k < 1 || t < 0)
      return false;
    int n = nums.length;
    Map<Long, Long> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      long value = (long) nums[i] - Integer.MIN_VALUE;
      long key = value / ((long) t + 1);
      if (map.containsKey(key) || map.containsKey(key - 1) && value - map.get(key - 1) <= t
          || map.containsKey(key + 1) && map.get(key + 1) - value <= t)
        return true;
      if (i >= k)
        map.remove(((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1));
      map.put(key, value);
    }
    return false;
  }
}
