package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets
{
	public List<List<Integer>> subsets(int[] S)
	{
		List<List<Integer>> result = new ArrayList<>();
		if (S == null || S.length == 0)
		{
			List<Integer> list = new ArrayList<>();
			result.add(list);
			return result;
		}
		else if (S.length == 1)
		{
			List<Integer> list = new ArrayList<>();
			result.add(list);
			list = new ArrayList<>();
			list.add(S[0]);
			result.add(list);
			return result;
		}
		else
		{
			Arrays.sort(S);
			List<List<Integer>> pre = subsets(Arrays.copyOfRange(S, 0,
					S.length - 1));
			for (List<Integer> list : pre)
			{
				result.add(list);
				List<Integer> list2 = new ArrayList<>(list);
				list2.add(S[S.length - 1]);
				result.add(list2);
			}
			return result;
		}
	}
}