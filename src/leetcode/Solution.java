package leetcode;

public class Solution
{
	public int numTrees(int n)
	{
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;
		int num = 0;
		for (int i = 1; i <= n / 2; i++)
		{
			num += 2 * (numTrees(i - 1) * numTrees(n - i));
		}
		if (n % 2 == 1)
			num += numTrees(n / 2) * numTrees(n / 2);
		return num;
	}

	public static void main(String[] args)
	{
		Solution s = new Solution();
		System.out.println("" + s.numTrees(3));
	}
}
