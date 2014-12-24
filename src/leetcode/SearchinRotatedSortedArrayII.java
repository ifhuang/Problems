package leetcode;

// https://oj.leetcode.com/problems/search-in-rotated-sorted-array-ii/
public class SearchinRotatedSortedArrayII {
	public boolean search(int[] A, int target) {
		int low = 0;
		int high = A.length - 1;
		while (low <= high) {
			int mid = (low + high) >>> 1;
			if (A[mid] == target)
				return true;
			else if (A[mid] > A[low])
				if (A[low] <= target && target < A[mid])
					high = mid - 1;
				else
					low = mid + 1;
			else if (A[mid] < A[low])
				if (A[mid] < target && target <= A[high])
					low = mid + 1;
				else
					high = mid - 1;
			else
				low++;
		}
		return false;
	}
}
