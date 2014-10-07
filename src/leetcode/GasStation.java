package leetcode;

public class GasStation
{
	public int canCompleteCircuit(int[] gas, int[] cost)
	{
		if (gas == null || gas.length == 0)
			return -1;
		else if (gas.length == 1 && gas[0] < cost[0])
			return -1;
		else if (gas.length == 1 && gas[0] >= cost[0])
			return 0;
		else
		{
			int length = gas.length;
			int[] diff = new int[length];
			for (int i = 0; i < length; i++)
				diff[i] = gas[i] - cost[i];
			for (int i = 0; i < length;)
				if (diff[i] >= 0)
				{
					int sum = diff[i];
					int j = i + 1;
					for (; j < i + length; j++)
					{
						int index = (j + length) % length;
						sum += diff[index];
						if (sum < 0)
							break;
					}
					if (j == i + length)
						return i;
					i = j;
				}
				else
					i++;
		}
		return -1;
	}
}