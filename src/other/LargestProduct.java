package other;

public class LargestProduct {
  public int largestProduct(int[] a) {
    int rightMax = 0;
    int ans = 0;
    for (int i = a.length - 1; i >= 0; i--) {
      if (a[i] < rightMax) {
        ans = Math.max(ans, a[i] * rightMax);
      } else {
        rightMax = a[i];
      }
    }
    return ans;
  }
}
