package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
// Given an array of integers that is already sorted in ascending order, find two numbers such that
// they add up to a specific target number.
// The function twoSum should return indices of the two numbers such that they add up to the target,
// where index1 must be less than index2. Please note that your returned answers (both index1 and
// index2) are not zero-based.
// You may assume that each input would have exactly one solution.
// Input: numbers={2, 7, 11, 15}, target=9
// Output: index1=1, index2=2
public class TwoSumIIInputarrayissorted {
  // time O(n), space O(n)
  public int[] twoSum(int[] numbers, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < numbers.length; i++) {
      int diff = target - numbers[i];
      if (map.containsKey(diff))
        return new int[] {map.get(diff) + 1, i + 1};
      map.put(numbers[i], i);
    }
    return null;
  }

  // time O(n), space O(1)
  public int[] twoSum2(int[] numbers, int target) {
    int low = 0, high = numbers.length - 1;
    while (low < high) {
      int sum = numbers[low] + numbers[high];
      if (sum == target) {
        break;
      } else if (sum > target) {
        high--;
      } else {
        low++;
      }
    }
    return new int[] {low + 1, high + 1};
  }
}
