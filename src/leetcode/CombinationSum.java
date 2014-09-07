package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum
{
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target)
	{
		if (candidates == null || candidates.length == 0)
		{
			return new ArrayList<>();
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);
		find(candidates, target, 0, new ArrayList<Integer>(), result);
		return result;
	}

	private void find(int[] candidates, int target, int start,
			ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result)
	{
		if (target < 0)
		{
			return;
		}
		else if (target == 0)
		{
			result.add(new ArrayList<>(list));
			return;
		}
		else
		{
			for (int i = start; i < candidates.length; i++)
			{
				if (i != 0 && candidates[i] == candidates[i - 1])
					continue;
				list.add(candidates[i]);
				find(candidates, target - candidates[i], i, list, result);
				list.remove(list.size() - 1);
			}
		}
	}
}
