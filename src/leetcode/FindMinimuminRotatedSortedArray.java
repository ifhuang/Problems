package leetcode;

// https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class FindMinimuminRotatedSortedArray {
  public int findMin(int[] num) {
    int low = 0;
    int high = num.length - 1;
    while (low < high) {
      int mid = (low + high) >>> 1;
      if (num[mid] > num[high])
        low = mid + 1;
      else
        high = mid;
    }
    return num[low];
  }
}
