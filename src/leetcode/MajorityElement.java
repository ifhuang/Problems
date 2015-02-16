package leetcode;

// https://oj.leetcode.com/problems/majority-element/
public class MajorityElement {
  public int majorityElement(int[] num) {
    int now = num[0];
    int count = 1;
    for (int i = 1; i < num.length; i++)
      if (now == num[i])
        count++;
      else if (count > 0)
        count--;
      else {
        now = num[i];
        count = 1;
      }
    return now;
  }
}
