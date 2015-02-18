package leetcode.algorithms;

// https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
public class FindMinimuminRotatedSortedArrayII {
  public int findMin(int[] num) {
    int low = 0;
    int high = num.length - 1;
    while (low < high) {
      int mid = (low + high) >>> 1;
      if (num[mid] > num[high])
        low = mid + 1;
      else if (num[mid] == num[high])
        high--;
      else
        high = mid;
    }
    return num[low];
  }
}
