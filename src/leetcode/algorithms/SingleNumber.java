package leetcode.algorithms;

// https://oj.leetcode.com/problems/single-number/
public class SingleNumber {
  public int singleNumber(int[] A) {
    int ans = 0;
    for (int a : A)
      ans ^= a;
    return ans;
  }
}
