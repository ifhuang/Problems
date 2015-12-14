package other;

public class GCDofArray {
  static int solve(int[] a) {
    int n = a.length;
    if (n == 0) {
      return 0;
    }
    int ans = a[0];
    for (int i : a) {
      ans = gcd(ans, i);
    }
    return ans;
  }

  static int gcd(int a, int b) {
    while (b > 0) {
      int t = a % b;
      a = b;
      b = t;
    }
    return a;
  }

  public static void main(String[] args) {
    System.out.println(solve(new int[] {}));
    System.out.println(solve(new int[] {5}));
    System.out.println(solve(new int[] {3, 5}));
    System.out.println(solve(new int[] {3, 6, 9}));
    System.out.println(solve(new int[] {12, 8, 16}));
  }
}
