package leetcode;

// https://oj.leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {
  public int trap(int[] A) {
    int len = A.length;
    if (len < 3)
      return 0;
    int[] leftMax = new int[len];
    leftMax[0] = A[0];
    for (int i = 1; i < len; i++)
      leftMax[i] = Math.max(A[i], leftMax[i - 1]);
    int[] rightMax = new int[len];
    rightMax[len - 1] = A[len - 1];
    for (int i = len - 2; i >= 0; i--)
      rightMax[i] = Math.max(A[i], rightMax[i + 1]);
    int ans = 0;
    for (int i = 0; i < len; i++)
      ans += Math.min(leftMax[i], rightMax[i]) - A[i];
    return ans;
  }
}
