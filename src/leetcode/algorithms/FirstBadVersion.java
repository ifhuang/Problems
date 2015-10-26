package leetcode.algorithms;

import leetcode.util.VersionControl;

// https://leetcode.com/problems/first-bad-version/
public class FirstBadVersion extends VersionControl {
  public int firstBadVersion(int n) {
    int start = 1, end = n;
    while (start < end) {
      int mid = (start + end) >>> 1;
      if (isBadVersion(mid)) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }
    return start;
  }
}
