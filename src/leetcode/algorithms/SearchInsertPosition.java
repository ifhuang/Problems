package leetcode.algorithms;

// https://oj.leetcode.com/problems/search-insert-position/
public class SearchInsertPosition {
  public int searchInsert(int[] A, int target) {
    int len = A.length;
    int low = 0;
    int high = len - 1;
    int mid = low;
    while (low < high) {
      mid = (low + high) >>> 1;
      if (A[mid] > target)
        high = mid - 1;
      else if (A[mid] < target)
        low = mid + 1;
      else
        return mid;
    }
    if (A[low] >= target)
      return low;
    else
      return low + 1;
  }
}
