package leetcode;

import java.util.LinkedList;
import java.util.List;

public class PermutationSequence
{
	public String getPermutation(int n, int k)
	{
		int total = 1;
		List<Integer> list = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++)
		{
			list.add(i);
			total *= i;
		}
		int copy = k - 1;
		for (int i = n; i >= 1; i--)
		{
			total /= i;
			int x = copy / total;
			copy = copy % total;
			int item = list.remove(x);
			sb.append(item);
		}
		return sb.toString();
	}

	public static void main(String[] args)
	{
		PermutationSequence solution = new PermutationSequence();
		System.out.println(solution.getPermutation(4, 15));
	}
}