package leetcode;

public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		int index = n - 1;
		if (index == -1)
			return "";
		char last = (char) ('A' + index % 26);
		return convertToTitle(index / 26) + last;
	}
}
