package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

// https://oj.leetcode.com/problems/palindrome-partitioning/
public class PalindromePartitioning {
  public List<List<String>> partition(String s) {
    int n = s.length();
    List<List<String>> ans = new ArrayList<>();
    if (check(s)) {
      List<String> list = new ArrayList<>();
      list.add(s);
      ans.add(list);
    }
    if (n > 1)
      for (int i = 1; i < n; i++) {
        String pre = s.substring(0, i);
        String post = s.substring(i);
        if (check(post)) {
          List<List<String>> preAns = partition(pre);
          for (List<String> preList : preAns) {
            List<String> list = new ArrayList<>(preList);
            list.add(post);
            ans.add(list);
          }
        }
      }
    return ans;
  }

  private boolean check(String s) {
    int n = s.length();
    for (int i = 0, j = n - 1; i < j; i++, j--)
      if (s.charAt(i) != s.charAt(j))
        return false;
    return true;
  }
}
