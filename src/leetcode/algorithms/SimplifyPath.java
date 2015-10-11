package leetcode.algorithms;

import java.util.Stack;

// https://oj.leetcode.com/problems/simplify-path/
public class SimplifyPath {
  public String simplifyPath(String path) {
    Stack<String> s = new Stack<>();
    for (String p : path.split("/")) {
      if (p.equals("") || p.equals(".")) {
      } else if (p.equals("..")) {
        if (!s.isEmpty()) {
          s.pop();
        }
      } else {
        s.push(p);
      }
    }
    StringBuilder sb = new StringBuilder();
    while (!s.isEmpty()) {
      sb.insert(0, s.pop()).insert(0, "/");
    }
    return sb.length() == 0 ? "/" : sb.toString();
  }
}
