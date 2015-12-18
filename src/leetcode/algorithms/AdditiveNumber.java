package leetcode.algorithms;

import java.math.BigInteger;

// https://leetcode.com/problems/additive-number/
public class AdditiveNumber {
  public boolean isAdditiveNumber(String num) {
    int n = num.length();
    for (int i = 1; i <= n; i++) {
      for (int j = i + 1; j <= n; j++) {
        BigInteger a = parse(num.substring(0, i));
        BigInteger b = parse(num.substring(i, j));
        if (a == null || b == null) {
          continue;
        }
        String c = a.add(b).toString();
        String d = num.substring(j);
        String e = num.substring(i);
        if (d.startsWith(c) && (d.length() == c.length() || isAdditiveNumber(e))) {
          return true;
        }
      }
    }
    return false;
  }

  private BigInteger parse(String s) {
    return s.startsWith("0") && s.length() > 1 ? null : new BigInteger(s);
  }
}
