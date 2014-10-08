package leetcode;

public class JumpGame
{
	public boolean canJump(int[] A)
	{
		if (A == null || A.length == 0)
			return false;
		else if (A.length == 1)
			return true;
		else
		{
			if (A[0] == 0)
				return false;
			int start = 0;
			while (start < A.length)
			{
				int index = findZero(start, A);
				if (index == A.length)
					return true;
				else if (index == A.length - 1)
				{
					int d = -1;
					int i = index - 1;
					for (; i >= 0; i--)
					{
						if (A[i] + d >= 0)
							return true;
						d--;
					}
					if (i == -1)
						return false;
				}
				else
				{
					int d = -1;
					int i = index - 1;
					for (; i >= 0; i--)
					{
						if (A[i] + d > 0)
							break;
						d--;
					}
					if (i == -1)
						return false;
				}
				start = index + 1;
			}
			return true;
		}
	}

	private int findZero(int start, int[] A)
	{
		int i = start;
		for (; i < A.length; i++)
			if (A[i] == 0)
				return i;
		return i;
	}
}