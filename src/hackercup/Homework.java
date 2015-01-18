package hackercup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Homework {

	static int[] help;

	static void loadHelp(String path, String path2) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(path));
		String[] part = br.readLine().split(",");
		br.close();
		help = new int[10000000 - 2 + 1];
		for (int i = 0; i < 9000000 - 2; i++) {
			help[i] = Integer.parseInt(part[i]);
		}
		BufferedReader br2 = new BufferedReader(new FileReader(path2));
		String[] part2 = br2.readLine().split(",");
		br2.close();
		for (int i = 9000000 - 2; i <= 10000000 - 2; i++) {
			help[i] = Integer.parseInt(part2[i - (9000000 - 2)]);
		}
	}

	static int solve(int A, int B, int K) {
		int count = 0;
		for (int i = A - 2; i <= B - 2; i++)
			if (help[i] == K)
				count++;
		return count;
	}

	public static void main(String[] args) throws Exception {
		loadHelp("Help.txt", "Help-2.txt");
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int k = 1;
		while (T-- > 0) {
			int A = scanner.nextInt();
			int B = scanner.nextInt();
			int K = scanner.nextInt();
			System.out.println(String.format("Case #%d: %d", k++,
					solve(A, B, K)));
		}
		scanner.close();
	}
}