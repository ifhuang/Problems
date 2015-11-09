package leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/remove-invalid-parentheses/
public class RemoveInvalidParentheses {
  public List<String> removeInvalidParentheses(String s) {
    List<String> ans = new ArrayList<>();
    Queue<String> queue = new LinkedList<>();
    Set<String> set = new HashSet<>();
    boolean found = false;
    queue.add(s);
    set.add(s);
    while (!queue.isEmpty()) {
      String t = queue.poll();
      if (check(t)) {
        ans.add(t);
        found = true;
      }
      if (!found) {
        for (int i = 0; i < t.length(); i++) {
          if (t.charAt(i) == '(' || t.charAt(i) == ')') {
            String n = t.substring(0, i) + t.substring(i + 1);
            if (!set.contains(n)) {
              queue.offer(n);
              set.add(n);
            }
          }
        }
      }
    }
    return ans;
  }

  private boolean check(String s) {
    int c = 0;
    for (int i = 0; i < s.length(); i++) {
      char x = s.charAt(i);
      if (x == '(') {
        c++;
      } else if (x == ')') {
        c--;
        if (c < 0) {
          return false;
        }
      }
    }
    return c == 0;
  }
}
