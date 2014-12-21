package leetcode;

import java.util.ArrayList;
import java.util.List;

// https://oj.leetcode.com/problems/combinations/
public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ans = new ArrayList<>();
		if (k == 1)
			for (int i = 1; i <= n; i++) {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				ans.add(list);
			}
		else {
			List<List<Integer>> pre = combine(n, k - 1);
			for (List<Integer> list : pre) {
				int last = list.get(list.size() - 1);
				while (last < n) {
					last++;
					List<Integer> copy = new ArrayList<>(list);
					copy.add(last);
					ans.add(copy);
				}
			}
		}
		return ans;
	}
}
