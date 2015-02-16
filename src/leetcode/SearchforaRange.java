package leetcode;

// https://oj.leetcode.com/problems/search-for-a-range/
public class SearchforaRange {
  public int[] searchRange(int[] A, int target) {
    int len = A.length;
    int low = 0;
    int high = len - 1;
    int midLeft = low;
    while (low <= high) {
      midLeft = (low + high) >>> 1;
      if (A[midLeft] < target)
        low = midLeft + 1;
      else if (A[midLeft] > target)
        high = midLeft - 1;
      else if (A[midLeft] == target) {
        if (midLeft == 0 || A[midLeft - 1] < A[midLeft])
          break;
        else
          high = midLeft - 1;
      }
    }
    if (low > high)
      return new int[] {-1, -1};
    low = 0;
    high = len - 1;
    int midRight = high;
    while (low <= high) {
      midRight = (low + high) >>> 1;
      if (A[midRight] < target)
        low = midRight + 1;
      else if (A[midRight] > target)
        high = midRight - 1;
      else if (A[midRight] == target) {
        if (midRight == len - 1 || A[midRight] < A[midRight + 1])
          break;
        else
          low = midRight + 1;
      }
    }
    return new int[] {midLeft, midRight};
  }
}
