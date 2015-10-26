package leetcode.algorithms;

// https://leetcode.com/problems/count-primes/
public class CountPrimes {

  public int countPrimes(int n) {
    boolean[] b = prime(n);
    int ans = 0;
    for (int i = 2; i < n; i++) {
      if (!b[i]) {
        ans++;
      }
    }
    return ans;
  }

  private boolean[] prime(int max) {
    boolean[] b = new boolean[max + 1];
    for (int i = 2; i * i <= max; i++) {
      if (!b[i]) {
        for (int j = i * i; j <= max; j += i) {
          b[j] = true;
        }
      }
    }
    return b;
  }

}
