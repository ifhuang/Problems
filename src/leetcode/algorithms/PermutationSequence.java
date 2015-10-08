package leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;

// https://oj.leetcode.com/problems/permutation-sequence/
public class PermutationSequence {
  // time O(n), space O(n)
  public String getPermutation(int n, int k) {
    int base = 1;
    List<Integer> list = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      base *= i;
      list.add(i);
    }
    k--;
    StringBuilder sb = new StringBuilder();
    for (int i = n; i >= 1; i--) {
      base /= i;
      int j = k / base;
      sb.append(list.remove(j));
      k %= base;
    }
    return sb.toString();
  }
}
