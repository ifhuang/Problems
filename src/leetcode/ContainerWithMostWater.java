package leetcode;

// https://oj.leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater
{
	public int maxArea(int[] height)
	{
		if (height == null || height.length < 2)
			return 0;
		int low = 0;
		int high = height.length - 1;
		int ans = 0;
		while (low < high)
		{
			ans = Math.max(ans, Math.min(height[low], height[high])
					* (high - low));
			if (height[low] < height[high])
				low++;
			else
				high--;
		}
		return ans;
	}
}
