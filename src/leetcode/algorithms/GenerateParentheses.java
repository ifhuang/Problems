package leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://oj.leetcode.com/problems/generate-parentheses/
public class GenerateParentheses {
  // recursive
  public List<String> generateParenthesis(int n) {
    if (n == 0) {
      List<String> list = new ArrayList<>();
      list.add("");
      return list;
    }
    Set<String> set = new HashSet<>();
    List<String> pre = generateParenthesis(n - 1);
    for (String s : pre) {
      for (int i = 0; i <= s.length(); i++) {
        StringBuilder sb = new StringBuilder(s);
        sb.insert(i, '(');
        for (int j = i + 1; j <= sb.length(); j++) {
          StringBuilder sb2 = new StringBuilder(sb);
          sb2.insert(j, ')');
          set.add(sb2.toString());
        }
      }
    }
    return new ArrayList<>(set);
  }

  // dfs
  public List<String> generateParenthesis2(int n) {
    List<String> ans = new ArrayList<>();
    backtrack(ans, "", 0, 0, n);
    return ans;
  }

  private void backtrack(List<String> ans, String now, int open, int close, int max) {
    if (open + close == max * 2) {
      ans.add(now);
      return;
    }
    if (open < max) {
      backtrack(ans, now + "(", open + 1, close, max);
    }
    if (open > close) {
      backtrack(ans, now + ")", open, close + 1, max);
    }
  }
}
