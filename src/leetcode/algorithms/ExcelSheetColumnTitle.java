package leetcode.algorithms;

// https://oj.leetcode.com/problems/excel-sheet-column-title/
public class ExcelSheetColumnTitle {
  public String convertToTitle(int n) {
    return n == 0 ? "" : convertToTitle((n - 1) / 26) + (char) ('A' + (n - 1) % 26);
  }
}
