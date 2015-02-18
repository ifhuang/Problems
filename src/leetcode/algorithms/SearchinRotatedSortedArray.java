package leetcode.algorithms;

// https://oj.leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchinRotatedSortedArray {
  public int search(int[] A, int target) {
    int len = A.length;
    int low = 0;
    int high = len - 1;
    while (low <= high) {
      int mid = (low + high) >>> 1;
      if (A[mid] == target)
        return mid;
      else if (A[low] <= A[mid]) {
        if (A[low] <= target && target < A[mid])
          high = mid - 1;
        else
          low = mid + 1;
      } else {
        if (A[mid] < target && target <= A[high])
          low = mid + 1;
        else
          high = mid - 1;
      }
    }
    return -1;
  }
}
