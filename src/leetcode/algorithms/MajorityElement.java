package leetcode.algorithms;

// https://oj.leetcode.com/problems/majority-element/
public class MajorityElement {
  public int majorityElement(int[] num) {
    int cur = 0;
    int cnt = 0;
    for (int i : num) {
      if (cur == i) {
        cnt++;
      } else if (cnt > 0) {
        cnt--;
      } else {
        cur = i;
        cnt = 1;
      }
    }
    return cur;
  }
}
