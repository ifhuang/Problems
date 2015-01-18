package hackercup;

import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Scanner;

public class WinningatSports {

	static int a;
	static int b;

	static int stressfree() {
		BigInteger[][] dp = new BigInteger[a + 1][b + 1];
		for (int i = 1; i < a + 1; i++) {
			dp[i][0] = new BigInteger("1");
			if (i < b + 1)
				dp[i][i] = new BigInteger("0");
		}
		for (int i = 2; i < a + 1; i++)
			for (int j = 1; j < i && j < b + 1; j++)
				dp[i][j] = dp[i - 1][j].add(dp[i][j - 1]);
		return dp[a][b].mod(new BigInteger("1000000007")).intValue();
	}

	static int stressful() {
		BigInteger[][] dp = new BigInteger[a + 1][b + 1];
		for (int i = 1; i < a + 1; i++)
			dp[i][0] = new BigInteger("1");
		for (int j = 1; j < b + 1; j++)
			dp[0][j] = new BigInteger("1");
		for (int i = 1; i < a + 1; i++)
			for (int j = 1; j < b + 1; j++) {
				dp[i][j] = dp[i - 1][j];
				if (i <= j - 1)
					dp[i][j] = dp[i][j].add(dp[i][j - 1]);
			}
		return dp[a][b].mod(new BigInteger("1000000007")).intValue();
	}

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		PrintStream ps = new PrintStream(System.out);
		int T = scanner.nextInt();
		int k = 1;
		scanner.nextLine();
		while (T-- > 0) {
			String s = scanner.nextLine();
			a = Integer.parseInt(s.split("-")[0]);
			b = Integer.parseInt(s.split("-")[1]);
			ps.println(String.format("Case #%d: %d %d", k++, stressfree(),
					stressful()));
		}
		scanner.close();
		ps.close();
	}
}