package leetcode.algorithms;

// https://oj.leetcode.com/problems/single-number-ii/
public class SingleNumberII {
  public int singleNumber(int[] A) {
    int one = 0;
    int two = 0;
    for (int a : A) {
      one = (one ^ a) & ~two;
      two = (two ^ a) & ~one;
    }
    return one;
  }
}
