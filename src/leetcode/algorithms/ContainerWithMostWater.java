package leetcode.algorithms;

// https://oj.leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {
  // time O(n), space O(1)
  public int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int ans = 0;
    while (left < right) {
      int water = (right - left) * Math.min(height[left], height[right]);
      ans = Math.max(ans, water);
      if (height[left] < height[right])
        left++;
      else
        right--;
    }
    return ans;
  }
}
