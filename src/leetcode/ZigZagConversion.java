package leetcode;

// https://oj.leetcode.com/problems/zigzag-conversion/
public class ZigZagConversion {
  public String convert(String s, int nRows) {
    int n = s.length();
    if (nRows == 1 || n <= nRows)
      return s;
    StringBuilder[] sb = new StringBuilder[nRows];
    for (int i = 0; i < nRows; i++)
      sb[i] = new StringBuilder();
    for (int i = 0; i < n; i += 2 * nRows - 2)
      sb[0].append(s.charAt(i));
    for (int i = nRows - 1; i < n; i += 2 * nRows - 2)
      sb[nRows - 1].append(s.charAt(i));
    for (int i = 1; i < nRows - 1; i++) {
      int flag = 0;
      for (int j = i; j < n;) {
        sb[i].append(s.charAt(j));
        if (flag == 0) {
          j += 2 * nRows - 2 - 2 * i;
          flag = 1;
        } else {
          j += 2 * i;
          flag = 0;
        }
      }
    }
    for (int i = 1; i < nRows; i++)
      sb[0].append(sb[i]);
    return sb[0].toString();
  }
}
