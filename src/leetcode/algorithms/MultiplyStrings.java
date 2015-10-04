package leetcode.algorithms;

// https://oj.leetcode.com/problems/multiply-strings/
public class MultiplyStrings {
  public String multiply(String num1, String num2) {
    int n1 = num1.length();
    int n2 = num2.length();
    if (n1 > n2) {
      return multiply(num2, num1);
    }
    String ans = "0";
    for (int i = 0; i < n1; i++) {
      String num = shift(num2, i);
      int d = num1.charAt(n1 - i - 1) - '0';
      String t = multi(num, d);
      ans = add(ans, t);
    }
    return ans;
  }

  private String add(String num1, String num2) {
    StringBuilder sb = new StringBuilder();
    int carry = 0;
    int n1 = num1.length();
    int n2 = num2.length();
    for (int i = 1; i <= Math.max(n1, n2); i++) {
      int i1 = n1 - i;
      int d1 = i1 >= 0 ? num1.charAt(i1) - '0' : 0;
      int i2 = n2 - i;
      int d2 = i2 >= 0 ? num2.charAt(i2) - '0' : 0;
      int sum = d1 + d2 + carry;
      sb.append(sum % 10);
      carry = sum / 10;
    }
    if (carry == 1) {
      sb.append(carry);
    }
    return sb.reverse().toString();
  }

  private String shift(String num, int d) {
    StringBuilder sb = new StringBuilder(num);
    for (int i = 0; i < d; i++) {
      sb.append(0);
    }
    return sb.toString();
  }

  private String multi(String num, int d) {
    if (d == 0) {
      return "0";
    } else if (d == 1) {
      return num;
    }
    String half = multi(num, d / 2);
    String sum = add(half, half);
    return d % 2 == 0 ? sum : add(sum, num);
  }

  public String multiply2(String num1, String num2) {
    int n1 = num1.length();
    int n2 = num2.length();
    int[] num = new int[n1 + n2];
    for (int i = n1 - 1; i >= 0; i--) {
      for (int j = n2 - 1; j >= 0; j--) {
        int d1 = num1.charAt(i) - '0';
        int d2 = num2.charAt(j) - '0';
        num[i + j + 1] += d1 * d2;
      }
    }
    int carry = 0;
    for (int i = num.length - 1; i >= 0; i--) {
      int t = num[i] + carry;
      num[i] = t % 10;
      carry = t / 10;
    }
    StringBuilder sb = new StringBuilder();
    for (int i : num) {
      sb.append(i);
    }
    while (sb.length() > 0 && sb.charAt(0) == '0') {
      sb.deleteCharAt(0);
    }
    return sb.length() == 0 ? "0" : sb.toString();
  }
}
