package leetcode;

import java.util.LinkedList;
import java.util.List;

public class PascalsTriangleII
{
	public List<Integer> getRow(int rowIndex)
	{
		List<Integer> result = new LinkedList<>();
		result.add(1);
		if (rowIndex == 0)
			return result;
		result.add(1);
		if (rowIndex == 1)
			return result;
		List<Integer> pre = result;
		for (int i = 0; i < rowIndex - 1; i++)
		{
			result = new LinkedList<>();
			result.add(1);
			for (int j = 0; j <= i; j++)
			{
				result.add(pre.get(j) + pre.get(j + 1));
			}
			result.add(1);
			pre = result;
		}
		return result;
	}
}