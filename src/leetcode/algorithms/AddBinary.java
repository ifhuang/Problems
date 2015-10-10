package leetcode.algorithms;

// https://oj.leetcode.com/problems/add-binary/
public class AddBinary {
  public String addBinary(String a, String b) {
    StringBuilder sb = new StringBuilder();
    int i = 1;
    int carry = 0;
    while (a.length() - i >= 0 || b.length() - i >= 0) {
      int sum = carry;
      if (a.length() - i >= 0) {
        sum += a.charAt(a.length() - i) - '0';
      }
      if (b.length() - i >= 0) {
        sum += b.charAt(b.length() - i) - '0';
      }
      sb.append(sum % 2);
      carry = sum / 2;
      i++;
    }
    if (carry == 1) {
      sb.append(1);
    }
    return sb.reverse().toString();
  }
}
