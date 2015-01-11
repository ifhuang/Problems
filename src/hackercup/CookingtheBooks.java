package hackercup;

import java.util.Scanner;

public class CookingtheBooks {

	static String tweak(String s, boolean small) {
		int n = s.length();
		String ans = s;
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++)
				if ((i == 0 && s.charAt(j) != '0') || i > 0) {
					String tmp = swap(s, i, j);
					if (small && tmp.compareTo(ans) < 0)
						ans = tmp;
					else if (!small && tmp.compareTo(ans) > 0)
						ans = tmp;
				}
		return ans;
	}

	static String swap(String s, int i, int j) {
		StringBuilder sb = new StringBuilder(s);
		sb.setCharAt(i, s.charAt(j));
		sb.setCharAt(j, s.charAt(i));
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int k = 1;
		scanner.nextLine();
		while (T-- > 0) {
			String s = scanner.nextLine();
			System.out.println(String.format("Case #%d: %s %s", k++,
					tweak(s, true), tweak(s, false)));
		}
		scanner.close();
	}
}
