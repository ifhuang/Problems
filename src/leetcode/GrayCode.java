package leetcode;

import java.util.LinkedList;
import java.util.List;

public class GrayCode
{
	public List<Integer> grayCode(int n)
	{
		List<Integer> list = new LinkedList<>();
		if (n < 1)
		{
			list.add(0);
			return list;
		}
		else
		{
			list = grayCode(n - 1);
			int size = list.size();
			int stub = (int) Math.pow(2, n - 1);
			for (int i = size - 1; i >= 0; i--)
				list.add(stub + list.get(i));
			return list;
		}
	}
}