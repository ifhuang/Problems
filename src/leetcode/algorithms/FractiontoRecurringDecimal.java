package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

public class FractiontoRecurringDecimal {
  public String fractionToDecimal(int numerator, int denominator) {
    long num = (long) numerator;
    long den = (long) denominator;
    String sign = num * den < 0 ? "-" : "";
    StringBuilder sb = new StringBuilder();
    num = Math.abs(num);
    den = Math.abs(den);
    sb.append(sign).append(num / den);
    num %= den;
    if (num == 0)
      return sb.toString();
    sb.append(".");
    Map<Long, Integer> map = new HashMap<>();
    map.put(num, sb.length());
    while (num > 0) {
      num *= 10;
      sb.append(num / den);
      num %= den;
      if (map.containsKey(num)) {
        sb.insert(map.get(num), "(");
        sb.append(")");
        break;
      }
      map.put(num, sb.length());
    }
    return sb.toString();
  }
}
