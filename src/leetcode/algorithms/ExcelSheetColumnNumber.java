package leetcode.algorithms;

// https://leetcode.com/problems/excel-sheet-column-number/
public class ExcelSheetColumnNumber {

  public int titleToNumber(String s) {
    if (s.length() == 0) {
      return 0;
    }
    int i = s.charAt(s.length() - 1) - 'A' + 1;
    return titleToNumber(s.substring(0, s.length() - 1)) * 26 + i;
  }

}
