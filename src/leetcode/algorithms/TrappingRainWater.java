package leetcode.algorithms;

// https://oj.leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {
  // time O(n), space O(n)
  public int trap(int[] height) {
    int n = height.length;
    int[] left = new int[n];
    int maxLeft = 0;
    for (int i = 1; i < n; i++) {
      maxLeft = Math.max(maxLeft, height[i - 1]);
      left[i] = maxLeft;
    }
    int[] right = new int[n];
    int maxRight = 0;
    for (int i = n - 2; i >= 0; i--) {
      maxRight = Math.max(maxRight, height[i + 1]);
      right[i] = maxRight;
    }
    int ans = 0;
    for (int i = 1; i < n - 1; i++) {
      ans += Math.max(Math.min(left[i], right[i]) - height[i], 0);
    }
    return ans;
  }

  // time O(n), space O(1)
  public int trap2(int[] height) {
    int left = 0, right = height.length - 1;
    int leftMax = 0, rightMax = 0;
    int ans = 0;
    while (left < right) {
      if (height[left] < height[right]) {
        ans += Math.max(leftMax - height[left], 0);
        leftMax = Math.max(leftMax, height[left]);
        left++;
      } else {
        ans += Math.max(rightMax - height[right], 0);
        rightMax = Math.max(rightMax, height[right]);
        right--;
      }
    }
    return ans;
  }
}
