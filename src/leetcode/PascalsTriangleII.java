package leetcode;

import java.util.ArrayList;
import java.util.List;

// https://oj.leetcode.com/problems/pascals-triangle-ii/
public class PascalsTriangleII {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> ans = new ArrayList<>();
		if (rowIndex == 0) {
			ans.add(1);
		} else {
			List<Integer> pre = getRow(rowIndex - 1);
			ans.add(1);
			for (int i = 0; i < rowIndex - 1; i++)
				ans.add(pre.get(i) + pre.get(i + 1));
			ans.add(1);
		}
		return ans;
	}
}