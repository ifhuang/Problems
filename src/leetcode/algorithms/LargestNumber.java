package leetcode.algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
  public String largestNumber(int[] num) {
    int n = num.length;
    String[] s = new String[n];
    for (int i = 0; i < n; i++)
      s[i] = num[i] + "";
    Comparator<String> c = new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return (o2 + o1).compareTo(o1 + o2);
      }
    };
    Arrays.sort(s, c);
    if (s[0].equals("0"))
      return "0";
    StringBuilder sb = new StringBuilder();
    for (String str : s)
      sb.append(str);
    return sb.toString();
  }
}
