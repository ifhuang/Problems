package leetcode;

public class JumpGameII
{
	public int jump(int[] A)
	{
		if (A == null || A.length < 2)
			return 0;
		else
		{
			int[] min = new int[A.length];
			for (int i = 0, l = 1; i < min.length; i++)
				while (l < min.length && l - i <= A[i])
					min[l++] = min[i] + 1;
			return min[min.length - 1];
		}
	}

	public static void main(String[] args)
	{
		JumpGameII solution = new JumpGameII();
		System.out.println("" + solution.jump(new int[] { 2, 3, 1, 1, 4 }));
	}
}