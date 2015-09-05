package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

// https://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinationsofaPhoneNumber {
  private String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  // recursive
  public List<String> letterCombinations(String digits) {
    List<String> ans = new ArrayList<>();
    if (digits.length() == 0) {
      return ans;
    }
    char first = digits.charAt(0);
    List<String> post = letterCombinations(digits.substring(1));
    if (first == '0' || first == '1') {
      return post;
    }
    for (char c : map[first - '0'].toCharArray()) {
      if (post.isEmpty()) {
        ans.add(c + "");
      } else {
        for (String item : post) {
          ans.add(c + item);
        }
      }
    }
    return ans;
  }

  // iterative
  public List<String> letterCombinations2(String digits) {
    List<List<String>> ans = new ArrayList<>();
    ans.add(new ArrayList<>());
    char[] c = digits.toCharArray();
    for (int i = 0; i < c.length; i++) {
      List<String> pre = ans.get(i);
      List<String> now = new ArrayList<>();
      if (c[i] == '0' || c[i] == '1') {
        now = pre;
      } else {
        for (char x : map[c[i] - '0'].toCharArray()) {
          if (pre.isEmpty()) {
            now.add("" + x);
          } else {
            for (String preI : pre) {
              now.add(preI + x);
            }
          }
        }
      }
      ans.add(now);
    }
    return ans.get(ans.size() - 1);
  }
}
