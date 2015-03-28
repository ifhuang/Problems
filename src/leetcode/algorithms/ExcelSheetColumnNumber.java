package leetcode.algorithms;

public class ExcelSheetColumnNumber {

  public int titleToNumber(String s) {
    return s.length() == 0 ? 0 : 26 * titleToNumber(s.substring(0, s.length() - 1))
        + s.charAt(s.length() - 1) - 'A' + 1;
  }

}
