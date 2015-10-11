package leetcode.algorithms;

// https://leetcode.com/problems/sort-colors/
public class SortColors {
  // time O(n), space O(1)
  public void sortColors(int[] nums) {
    int[] c = new int[3];
    for (int num : nums) {
      c[num]++;
    }
    for (int i = 0; i < nums.length; i++) {
      if (c[0] > 0) {
        nums[i] = 0;
        c[0]--;
      } else if (c[1] > 0) {
        nums[i] = 1;
        c[1]--;
      } else {
        nums[i] = 2;
        c[2]--;
      }
    }
  }

  // time O(n), space O(1)
  public void sortColors2(int[] nums) {
    int z = 0, o = 0, t = 0;
    for (int num : nums) {
      if (num == 0) {
        nums[t++] = 2;
        nums[o++] = 1;
        nums[z++] = 0;
      } else if (num == 1) {
        nums[t++] = 2;
        nums[o++] = 1;
      } else {
        nums[t++] = 2;
      }
    }
  }
}
