package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CombinationSumII
{
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target)
	{
		if (num == null || num.length == 0)
		{
			return new ArrayList<>();
		}
		Arrays.sort(num);
		HashSet<ArrayList<Integer>> result = new HashSet<>();
		find(num, target, 0, new ArrayList<Integer>(), result);
		return new ArrayList<>(result);
	}

	private void find(int[] num, int target, int start,
			ArrayList<Integer> list, HashSet<ArrayList<Integer>> result)
	{
		if (target < 0)
		{
			return;
		}
		else if (target == 0)
		{
			result.add(new ArrayList<>(list));
		}
		else
		{
			for (int i = start; i < num.length; i++)
			{
				list.add(num[i]);
				find(num, target - num[i], i + 1, list, result);
				list.remove(list.size() - 1);
			}
		}
	}
}
