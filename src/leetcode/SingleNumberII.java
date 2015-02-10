package leetcode;

// https://oj.leetcode.com/problems/single-number-ii/
public class SingleNumberII {
  public int singleNumber(int[] A) {
    int first = 0;
    int second = 0;
    for (int a : A) {
      first = (first ^ a) & ~second;
      second = (second ^ a) & ~first;
    }
    return first;
  }
}
