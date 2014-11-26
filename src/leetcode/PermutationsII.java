package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// https://oj.leetcode.com/problems/permutations-ii/
public class PermutationsII
{
	public List<List<Integer>> permuteUnique(int[] num)
	{
		Set<List<Integer>> ans = new HashSet<>();
		int len = num.length;
		if (len == 0)
			;
		else if (len == 1)
		{
			List<Integer> list = new LinkedList<>();
			list.add(num[0]);
			ans.add(list);
		}
		else
		{
			int[] preNum = Arrays.copyOfRange(num, 0, len - 1);
			int endNum = num[len - 1];
			List<List<Integer>> preAns = permuteUnique(preNum);
			for (List<Integer> preList : preAns)
				for (int i = 0; i <= preList.size(); i++)
				{
					List<Integer> list = new LinkedList<>(preList);
					list.add(i, endNum);
					ans.add(list);
				}
		}
		return new LinkedList<>(ans);
	}
}