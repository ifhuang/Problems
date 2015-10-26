package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/majority-element-ii/
public class MajorityElementII {
  public List<Integer> majorityElement(int[] nums) {
    int[] n = {0, 1};
    int[] c = {0, 0};
    for (int num : nums) {
      int j = 0;
      for (; j < 2; j++) {
        if (num == n[j]) {
          c[j]++;
          break;
        }
      }
      if (j == 2) {
        j = 0;
        for (; j < 2; j++) {
          if (c[j] == 0) {
            n[j] = num;
            c[j] = 1;
            break;
          }
        }
        if (j == 2) {
          j = 0;
          for (; j < 2; j++) {
            c[j]--;
          }
        }
      }
    }
    c[0] = c[1] = 0;
    for (int num : nums) {
      for (int j = 0; j < 2; j++) {
        if (num == n[j]) {
          c[j]++;
        }
      }
    }
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < 2; i++) {
      if (c[i] > nums.length / 3) {
        ans.add(n[i]);
      }
    }
    return ans;
  }
}
