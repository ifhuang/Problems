package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generalized-abbreviation/
// Write a function to generate the generalized abbreviations of a word.
// Example:
// Given word = "word", return the following list (order does not matter):
// ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2",
// "2r1", "3d", "w3", "4"]
public class GeneralizedAbbreviation {
  public List<String> generateAbbreviations(String word) {
    List<String> ans = new ArrayList<>();
    dfs(word, "", 0, ans);
    return ans;
  }

  private void dfs(String word, String pre, int index, List<String> ans) {
    if (word.length() == index) {
      ans.add(trans(pre));
      return;
    }
    dfs(word, pre + "1", index + 1, ans);
    dfs(word, pre + word.charAt(index), index + 1, ans);
  }

  private String trans(String s) {
    StringBuilder sb = new StringBuilder();
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '1') {
        count++;
      } else {
        if (count != 0) {
          sb.append(count);
        }
        sb.append(s.charAt(i));
        count = 0;
      }
    }
    if (count != 0) {
      sb.append(count);
    }
    return sb.toString();
  }
}
