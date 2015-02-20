package leetcode.algorithms;

import java.util.Arrays;

public class MaximumGap {
  public int maximumGap(int[] num) {
    int n = num.length;
    if (n < 2)
      return 0;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int i : num) {
      min = Math.min(min, i);
      max = Math.max(max, i);
    }
    int gap = (int) Math.ceil((double) (max - min) / (n - 1));
    int[] bMin = new int[n - 1];
    Arrays.fill(bMin, Integer.MAX_VALUE);
    int[] bMax = new int[n - 1];
    Arrays.fill(bMax, Integer.MIN_VALUE);
    for (int i : num)
      if (i != min && i != max) {
        int index = (i - min) / gap;
        bMin[index] = Math.min(bMin[index], i);
        bMax[index] = Math.max(bMax[index], i);
      }
    int ans = Integer.MIN_VALUE;
    int pre = min;
    for (int i = 0; i < n - 1; i++)
      if (bMin[i] != Integer.MAX_VALUE || bMax[i] != Integer.MIN_VALUE) {
        ans = Math.max(ans, bMin[i] - pre);
        pre = bMax[i];
      }
    ans = Math.max(ans, max - pre);
    return ans;
  }
}
