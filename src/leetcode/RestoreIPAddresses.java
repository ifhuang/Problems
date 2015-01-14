package leetcode;

import java.util.ArrayList;
import java.util.List;

// https://oj.leetcode.com/problems/restore-ip-addresses/
public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
		int n = s.length();
		List<String> ans = new ArrayList<>();
		for (int a = 1; a <= 3; a++)
			for (int b = 1; b <= 3; b++)
				for (int c = 1; c <= 3; c++)
					for (int d = 1; d <= 3; d++) {
						if (a > n)
							break;
						String sa = s.substring(0, a);
						if (!check(sa))
							continue;
						if (a + b > n)
							break;
						String sb = s.substring(a, a + b);
						if (!check(sb))
							continue;
						if (a + b + c > n)
							break;
						String sc = s.substring(a + b, a + b + c);
						if (!check(sc))
							continue;
						if (a + b + c + d > n)
							break;
						String sd = s.substring(a + b + c, a + b + c + d);
						if (!check(sd) || a + b + c + d != n)
							continue;
						StringBuilder builder = new StringBuilder();
						builder.append(sa).append(".").append(sb).append(".")
								.append(sc).append(".").append(sd);
						ans.add(builder.toString());
					}
		return ans;
	}
	private boolean check(String s) {
		int n = s.length();
		if (n == 1)
			return true;
		else if (s.charAt(0) == '0')
			return false;
		int num = Integer.parseInt(s);
		return num < 256;
	}
}
