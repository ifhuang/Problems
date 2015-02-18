package leetcode.algorithms;

// https://oj.leetcode.com/problems/plus-one/
public class PlusOne {
  public int[] plusOne(int[] digits) {
    int len = digits.length;
    int i = 0;
    for (; i < len; i++)
      if (digits[i] != 9)
        break;
    if (i == len) {
      int[] ans = new int[len + 1];
      ans[0] = 1;
      return ans;
    }
    int[] ans = new int[len];
    int flag = 1;
    for (i = len - 1; i >= 0; i--) {
      int num = digits[i] + flag;
      ans[i] = num % 10;
      flag = num / 10;
    }
    return ans;
  }
}
