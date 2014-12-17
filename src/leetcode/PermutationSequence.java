package leetcode;

import java.util.LinkedList;
import java.util.List;

// https://oj.leetcode.com/problems/permutation-sequence/
public class PermutationSequence {
	public String getPermutation(int n, int k) {
		List<Integer> dic = new LinkedList<>();
		int total = 1;
		for (int i = 1; i <= n; i++) {
			dic.add(i);
			total *= i;
		}
		StringBuilder sb = new StringBuilder();
		k--;
		while (n > 0) {
			total /= n;
			n--;
			sb.append(dic.remove(k / total));
			k = k % total;
		}
		return sb.toString();
	}
}