package leetcode.algorithms;

// https://oj.leetcode.com/problems/roman-to-integer/
public class RomantoInteger {
  private static int[] integers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
  private static String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V",
      "IV", "I"};

  public int romanToInt(String s) {
    int ans = 0;
    while (!s.isEmpty()) {
      for (int j = 0; j < romans.length; j++)
        if (s.startsWith(romans[j])) {
          ans += integers[j];
          s = s.substring(romans[j].length());
          break;
        }
    }
    return ans;
  }
}
