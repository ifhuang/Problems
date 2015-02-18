package leetcode.algorithms;

// https://oj.leetcode.com/problems/powx-n/
public class Powxn {
  public double pow(double x, int n) {
    if (n == Integer.MIN_VALUE) {
      if (Double.compare(x, 1) == 0 || Double.compare(x, -1) == 0)
        return 1;
      else
        return 0;
    } else if (n < 0)
      return 1 / pow(x, -n);
    else if (n == 0)
      return 1;
    else {
      double temp = pow(x, n / 2);
      if (n % 2 == 1)
        return temp * temp * x;
      else
        return temp * temp;
    }
  }
}
