package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/strobogrammatic-number-ii/
// A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at
// upside down).
// Find all strobogrammatic numbers that are of length = n.
// For example,
// Given n = 2, return ["11","69","88","96"].
// Hint:
// Try to use recursion and notice that it should recurse with n - 2 instead of n - 1.
public class StrobogrammaticNumberII {
  public List<String> findStrobogrammatic(int n) {
    return helper(n, n);
  }

  List<String> helper(int n, int m) {
    if (n == 0) {
      return new ArrayList<>(Arrays.asList(""));
    } else if (n == 1) {
      return new ArrayList<>(Arrays.asList("0", "1", "8"));
    }
    List<String> list = helper(n - 2, m);
    List<String> res = new ArrayList<>();
    for (String s : list) {
      if (n < m) {
        res.add("0" + s + "0");
      }
      res.add("1" + s + "1");
      res.add("6" + s + "9");
      res.add("8" + s + "8");
      res.add("9" + s + "6");
    }
    return res;
  }
}
