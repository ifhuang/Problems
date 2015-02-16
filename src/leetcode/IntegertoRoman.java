package leetcode;

// https://oj.leetcode.com/problems/integer-to-roman/
public class IntegertoRoman {
  private static int[] val = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
  private static String[] sym = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV",
      "I"};

  public String intToRoman(int num) {
    StringBuilder sb = new StringBuilder();
    while (num > 0) {
      for (int i = 0; i < val.length; i++)
        if (num >= val[i]) {
          num -= val[i];
          sb.append(sym[i]);
          break;
        }
    }
    return sb.toString();
  }
}
