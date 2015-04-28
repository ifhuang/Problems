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
    long b = 1L;
    for (long i = 1L; i <= up; i++) {
      a *= down + 1L - i;
      b *= i;
    }
    return a / b;
  }

}
