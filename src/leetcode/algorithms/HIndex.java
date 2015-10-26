package leetcode.algorithms;

import java.util.Arrays;

// https://leetcode.com/problems/h-index/
public class HIndex {
  public int hIndex(int[] citations) {
    Arrays.sort(citations);
    int len = citations.length;
    for (int i = 0; i < len; i++) {
      if (citations[i] >= len - i) {
        return len - i;
      }
    }
    return 0;
  }

  public int hIndex2(int[] citations) {
    int len = citations.length;
    int[] count = new int[len + 1];
    for (int c : citations) {
      count[c > len ? len : c]++;
    }
    int total = 0;
    for (int i = len; i >= 0; i--) {
      total += count[i];
      if (total >= i) {
        return i;
      }
    }
    return 0;
  }
}
