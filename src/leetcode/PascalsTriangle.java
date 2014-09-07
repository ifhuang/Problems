package leetcode;

import java.util.LinkedList;
import java.util.List;

public class PascalsTriangle
{
	public List<List<Integer>> generate(int numRows)
	{
		List<List<Integer>> result = new LinkedList<>();
		if (numRows == 0)
			return result;
		List<Integer> item = new LinkedList<>();
		item.add(1);
		result.add(item);
		if (numRows == 1)
			return result;
		item = new LinkedList<>();
		item.add(1);
		item.add(1);
		result.add(item);
		if (numRows == 2)
			return result;
		List<Integer> pre = item;
		for (int i = 0; i < numRows - 2; i++)
		{
			item = new LinkedList<>();
			item.add(1);
			for (int j = 0; j <= i; j++)
			{
				item.add(pre.get(j) + pre.get(j + 1));
			}
			item.add(1);
			result.add(item);
			pre = item;
		}
		return result;
	}
}
