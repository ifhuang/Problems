package leetcode;

// https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
public class RemoveDuplicatesfromSortedArrayII {
	public int removeDuplicates(int[] A) {
		int len = A.length;
		if (len == 0)
			return 0;
		int now = A[0];
		int nowCount = 1;
		int allCount = 1;
		for (int i = 1; i < len; i++)
			if (A[i] != now) {
				A[allCount] = A[i];
				now = A[i];
				nowCount = 1;
				allCount++;
			} else if (nowCount == 1) {
				A[allCount] = A[i];
				nowCount++;
				allCount++;
			}
		return allCount;
	}
}