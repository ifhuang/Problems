package leetcode.algorithms;

// https://oj.leetcode.com/problems/next-permutation/
public class NextPermutation {
  public void nextPermutation(int[] num) {
    int i = num.length - 1;
    for (; i > 0; i--)
      if (num[i - 1] < num[i])
        break;
    if (i > 0) {
      int j = num.length - 1;
      for (; j >= i; j--)
        if (num[j] > num[i - 1])
          break;
      int t = num[i - 1];
      num[i - 1] = num[j];
      num[j] = t;
    }
    for (int j = num.length - 1; i < j; i++, j--) {
      int t = num[i];
      num[i] = num[j];
      num[j] = t;
    }
  }
}
