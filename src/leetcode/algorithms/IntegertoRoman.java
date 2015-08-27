package leetcode.algorithms;

// https://oj.leetcode.com/problems/integer-to-roman/
public class IntegertoRoman {
  private String[] M = {"", "M", "MM", "MMM"};
  private String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
  private String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
  private String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

  // time O(1), space O(1)
  public String intToRoman(int num) {
    StringBuilder ans = new StringBuilder();
    ans.append(M[num / 1000]).append(C[num % 1000 / 100]).append(X[num % 100 / 10])
        .append(I[num % 10]);
    return ans.toString();
  }
}
