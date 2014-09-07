package leetcode;

public class ContainerWithMostWater
{
	public int maxArea(int[] height)
	{
		if (height == null || height.length < 2)
			return 0;
		int left = 0;
		int right = height.length - 1;
		int result = 0;
		while (left < right)
		{
			int now = Math.min(height[left], height[right]) * (right - left);
			result = Math.max(result, now);
			if (height[left] < height[right])
			{
				left++;
			}
			else
			{
				right--;
			}
		}
		return result;
	}
}
