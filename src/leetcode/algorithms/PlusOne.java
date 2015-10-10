package leetcode.algorithms;

// https://oj.leetcode.com/problems/plus-one/
public class PlusOne {
  public int[] plusOne(int[] digits) {
    int n = digits.length;
    int i = n;
    while (--i >= 0) {
      if (digits[i] != 9) {
        break;
      }
    }
    if (i == -1) {
      int[] a = new int[n + 1];
      a[0] = 1;
      return a;
    } else {
      int[] a = new int[n];
      for (int j = 0; j <= i; j++) {
        a[j] = digits[j];
      }
      a[i]++;
      return a;
    }
  }
}
