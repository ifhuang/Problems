package hackercup;

import java.util.Scanner;

public class NewYearsResolution {

	static boolean dfs(int gp, int gc, int gf, int[] p, int[] c, int[] f,
			int i, int n) {
		if (gp < 0 || gc < 0 || gf < 0)
			return false;
		else if (gp == 0 && gc == 0 && gf == 0)
			return true;
		for (int s = i; s < n; s++)
			if (dfs(gp - p[s], gc - c[s], gf - f[s], p, c, f, i + 1, n))
				return true;
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int k = 1;
		while (T-- > 0) {
			int gp = scanner.nextInt();
			int gc = scanner.nextInt();
			int gf = scanner.nextInt();
			int n = scanner.nextInt();
			int[] p = new int[n];
			int[] c = new int[n];
			int[] f = new int[n];
			for (int i = 0; i < n; i++) {
				p[i] = scanner.nextInt();
				c[i] = scanner.nextInt();
				f[i] = scanner.nextInt();
			}
			if (dfs(gp, gc, gf, p, c, f, 0, n))
				System.out.println(String.format("Case #%d: yes", k++));
			else
				System.out.println(String.format("Case #%d: no", k++));
		}
		scanner.close();
	}
}
