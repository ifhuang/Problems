package leetcode.algorithms;

public class AddDigits {
  public int addDigits(int num) {
    if (num / 10 == 0)
      return num;
    else {
      int t = 0;
      while (num > 0) {
        t += num % 10;
        num /= 10;
      }
      return addDigits(t);
    }
  }

  public int addDigits2(int num) {
    if (num == 0)
      return 0;
    else if (num % 9 == 0)
      return 9;
    else
      return num % 9;
  }
}
