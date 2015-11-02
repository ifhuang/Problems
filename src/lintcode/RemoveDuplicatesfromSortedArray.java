package lintcode;

// http://www.lintcode.com/en/problem/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesfromSortedArray {
  /**
   * @param A: a array of integers
   * @return : return an integer
   */
  public int removeDuplicates(int[] nums) {
    // write your code here
    int i = -1;
    int j = 0;
    while (j < nums.length) {
      if (i == -1 || nums[i] != nums[j]) {
        i++;
        nums[i] = nums[j];
      }
      j++;
    }
    return i + 1;
  }
}
