package other;

import java.util.Arrays;

public class WindowSum {
  public int[] solve(int[] a, int k) {
    int n = a.length;
    if (n <= 0 || k <= 0 || n < k) {
      return new int[] {};
    }
    int[] ans = new int[n - k + 1];
    for (int i = 0; i < k; i++) {
      ans[0] += a[i];
    }
    for (int i = 1; i < ans.length; i++) {
      ans[i] = ans[i - 1] - a[i - 1] + a[i + k - 1];
    }
    return ans;
  }

  public static void main(String[] args) {
    WindowSum ws = new WindowSum();
    int[] a = {1, 2, 3, 4, 5, 6};
    System.out.println(Arrays.toString(ws.solve(a, 3)));
  }
}
