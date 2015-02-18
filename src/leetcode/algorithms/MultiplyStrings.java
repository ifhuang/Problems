package leetcode.algorithms;

// https://oj.leetcode.com/problems/multiply-strings/
public class MultiplyStrings {
  public String multiply(String num1, String num2) {
    String ans = "0";
    if (num1.equals("0") || num2.equals("0"))
      return ans;
    int len1 = num1.length();
    int len2 = num2.length();
    if (len1 < len2)
      return multiply(num2, num1);
    for (int i = len2 - 1; i >= 0; i--) {
      char c = num2.charAt(i);
      StringBuilder sb = new StringBuilder(multiplyNum(num1, c));
      for (int j = 0; j < len2 - 1 - i; j++)
        sb.append('0');
      ans = sum(ans, sb.toString());
    }
    return ans;
  }

  private String multiplyNum(String num1, char num2) {
    int len1 = num1.length();
    int flag = 0;
    StringBuilder sb = new StringBuilder();
    int n2 = Character.getNumericValue(num2);
    if (n2 == 0)
      return "0";
    for (int i = len1 - 1; i >= 0; i--) {
      int n1 = Character.getNumericValue(num1.charAt(i));
      int tmp = n1 * n2 + flag;
      flag = tmp / 10;
      sb.insert(0, tmp % 10);
    }
    if (flag != 0)
      sb.insert(0, flag);
    return sb.toString();
  }

  private String sum(String num1, String num2) {
    int len1 = num1.length();
    int len2 = num2.length();
    int flag = 0;
    StringBuilder sb = new StringBuilder();
    if (len1 > len2)
      return sum(num2, num1);
    for (int i = len1 - 1, j = len2 - 1; j >= 0; i--, j--) {
      int n1 = 0;
      if (i >= 0)
        n1 = Character.getNumericValue(num1.charAt(i));
      int n2 = Character.getNumericValue(num2.charAt(j));
      int tmp = n1 + n2 + flag;
      flag = tmp / 10;
      sb.insert(0, tmp % 10);
    }
    if (flag != 0)
      sb.insert(0, flag);
    return sb.toString();
  }
}
