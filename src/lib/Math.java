package lib;

public class Math {

  /**
   * combination (up <= down)
   * 
   * @param up
   * @param down
   * @return
   */
  static long combination(long up, long down) {
    if (down - up < up)
      return combination(down - up, down);
    long a = 1L;
    for (long i = 1L; i <= up; i++) {
      a *= down + 1L - i;
      a /= i;
    }
    return a;
  }

  /**
   * prime (b[i] is false)
   * 
   * @param max
   * @return
   */
  static boolean[] prime(int max) {
    boolean[] b = new boolean[max + 1];
    for (int i = 2; i * i <= max; i++)
      if (!b[i])
        for (int j = i * i; j <= max; j += i)
          b[j] = true;
    return b;
  }

  /**
   * greatest common divisor
   * 
   * @param a
   * @param b
   * @return
   */
  static long gcd(long a, long b) {
    while (b > 0) {
      long t = a % b;
      a = b;
      b = t;
    }
    return a;
  }

  /**
   * binomial coefficients
   * 
   * @param n
   * @return
   */
  static long[][] bc(int n) {
    long[][] bc = new long[n][n];
    for (int i = 0; i < n; i++) {
      bc[i][0] = bc[i][i] = 1;
      for (int j = 1; j < i; j++)
        bc[i][j] = bc[i - 1][j - 1] + bc[i - 1][j];
    }
    return bc;
  }

}
