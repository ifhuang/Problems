package leetcode;

// https://oj.leetcode.com/problems/minimum-window-substring/
public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		int[] count = new int[128];
		boolean[] has = new boolean[128];
		int tL = T.length();
		for (int i = 0; i < tL; i++) {
			int index = T.charAt(i) - 'A';
			count[index]++;
			has[index] = true;
		}
		int sL = S.length();
		int post = -1;
		int pre = -1;
		int total = tL;
		int start = 0;
		int len = Integer.MAX_VALUE;
		while (post < sL && pre < sL) {
			if (total > 0) {
				post++;
				if (post == sL)
					break;
				int index = S.charAt(post) - 'A';
				count[index]--;
				if (has[index] && count[index] >= 0)
					total--;
			} else {
				pre++;
				if (pre == sL)
					break;
				int index = S.charAt(pre) - 'A';
				int newLen = post - pre + 1;
				if (has[index] && len > newLen) {
					start = pre;
					len = newLen;
				}
				count[index]++;
				if (has[index] && count[index] > 0)
					total++;
			}
		}
		return len == Integer.MAX_VALUE ? "" : S.substring(start, start + len);
	}
}
