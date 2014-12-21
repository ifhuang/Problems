package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://oj.leetcode.com/problems/subsets/
public class Subsets {
	public List<List<Integer>> subsets(int[] S) {
		Arrays.sort(S);
		return subsetsHelper(S, S.length - 1);
	}

	private List<List<Integer>> subsetsHelper(int[] S, int i) {
		List<List<Integer>> ans = new ArrayList<>();
		if (i == 0) {
			List<Integer> list = new ArrayList<>();
			ans.add(list);
			list = new ArrayList<>();
			list.add(S[i]);
			ans.add(list);
		} else {
			List<List<Integer>> pre = subsetsHelper(S, i - 1);
			List<List<Integer>> copy = new ArrayList<>(pre);
			ans.addAll(copy);
			for (List<Integer> list : copy) {
				List<Integer> copy2 = new ArrayList<>(list);
				copy2.add(S[i]);
				ans.add(copy2);
			}
		}
		return ans;
	}
}