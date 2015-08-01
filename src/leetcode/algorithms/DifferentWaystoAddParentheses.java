package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaystoAddParentheses {
  public List<Integer> diffWaysToCompute(String input) {
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (!Character.isDigit(c)) {
        List<Integer> pre = diffWaysToCompute(input.substring(0, i));
        List<Integer> post = diffWaysToCompute(input.substring(i + 1));
        for (int prei : pre)
          for (int posti : post)
            if (c == '+')
              ans.add(prei + posti);
            else if (c == '-')
              ans.add(prei - posti);
            else if (c == '*')
              ans.add(prei * posti);
      }
    }
    if (ans.isEmpty())
      ans.add(Integer.parseInt(input));
    return ans;
  }
}
