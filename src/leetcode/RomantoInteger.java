package leetcode;

// https://oj.leetcode.com/problems/roman-to-integer/
public class RomantoInteger {
  private static int[] val = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
  private static String[] sym = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV",
      "I"};

  public int romanToInt(String s) {
    int num = 0;
    while (!s.isEmpty())
      for (int i = 0; i < sym.length; i++)
        if (s.startsWith(sym[i])) {
          num += val[i];
          s = s.substring(sym[i].length());
          break;
        }
    return num;
  }
}
