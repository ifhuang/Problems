package leetcode.algorithms;

// https://oj.leetcode.com/problems/excel-sheet-column-title/
public class ExcelSheetColumnTitle {
  public String convertToTitle(int n) {
    if (n == 0) {
      return "";
    }
    int index = n - 1;
    return convertToTitle(index / 26) + (char) ('A' + index % 26);
  }
}
