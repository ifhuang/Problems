package leetcode.algorithms;

public class FindPeakElement {
  public int findPeakElement(int[] num) {
    int low = 0;
    int high = num.length - 1;
    while (low < high) {
      int mid = (low + high) >>> 1;
      if (num[mid] > num[mid + 1])
        high = mid;
      else
        low = mid + 1;
    }
    return low;
  }
}
