package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// http://www.lintcode.com/en/problem/subarray-sum/
public class SubarraySum {
  /**
   * @param nums: A list of integers
   * @return: A list of integers includes the index of the first number and the index of the last
   *          number
   */
  public ArrayList<Integer> subarraySum(int[] nums) {
    // write your code here
    int n = nums.length;
    int[] pre = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      pre[i] = pre[i - 1] + nums[i - 1];
    }
    Map<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      if (map.containsKey(pre[i])) {
        list.add(map.get(pre[i]));
        list.add(i - 1);
        break;
      } else {
        map.put(pre[i], i);
      }
    }
    return list;
  }
}
