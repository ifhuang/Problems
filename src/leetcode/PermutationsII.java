package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII
{
	public List<List<Integer>> permuteUnique(int[] num)
	{
		List<List<Integer>> result = new ArrayList<>();
		if (num == null || num.length == 0)
			return result;
		if (num.length == 1)
		{
			List<Integer> list = new ArrayList<>();
			list.add(num[0]);
			result.add(list);
			return result;
		}
		else
		{
			List<List<Integer>> pre = permuteUnique(Arrays.copyOfRange(num, 0,
					num.length - 1));
			Set<List<Integer>> set = new HashSet<>();
			for (List<Integer> list : pre)
			{
				for (int i = 0; i <= list.size(); i++)
				{
					List<Integer> newList = new ArrayList<>(list);
					newList.add(i, num[num.length - 1]);
					set.add(newList);
				}
			}
			List<List<Integer>> result2 = new ArrayList<>(set);
			return result2;
		}
	}
}