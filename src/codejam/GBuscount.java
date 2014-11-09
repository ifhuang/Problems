package codejam;

import java.util.Scanner;

public class GBuscount
{
	static int num;
	static int[] start;
	static int[] end;
	static int city;

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int k = 1;
		while (T-- > 0)
		{
			num = scanner.nextInt();
			start = new int[num];
			end = new int[num];
			for (int i = 0; i < num; i++)
			{
				start[i] = scanner.nextInt();
				end[i] = scanner.nextInt();
			}
			city = scanner.nextInt();
			System.out.print(String.format("Case #%d:", k++));
			for (int i = 0; i < city; i++)
			{
				int c = scanner.nextInt();
				int count = 0;
				for (int j = 0; j < num; j++)
				{
					if (c >= start[j] && c <= end[j])
						count++;
				}
				System.out.print(String.format(" %d", count));
			}
			System.out.println();
		}
		scanner.close();
	}
}
