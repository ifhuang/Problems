package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://oj.leetcode.com/problems/generate-parentheses/
public class GenerateParentheses {
  public List<String> generateParenthesis(int n) {
    Set<String> set = new HashSet<>();
    if (n == 0) {
      set.add("");
      return new ArrayList<>(set);
    }
    List<String> small = generateParenthesis(n - 1);
    for (String s : small)
      for (int i = 0; i <= s.length(); i++) {
        StringBuilder sb = new StringBuilder(s);
        sb.insert(i, "(");
        for (int j = i + 1; j <= s.length() + 1; j++) {
          StringBuilder sb2 = new StringBuilder(sb);
          sb2.insert(j, ")");
          set.add(sb2.toString());
        }
      }
    return new ArrayList<>(set);
  }
}
