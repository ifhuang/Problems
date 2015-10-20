package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

// https://oj.leetcode.com/problems/restore-ip-addresses/
public class RestoreIPAddresses {
  public List<String> restoreIpAddresses(String s) {
    List<String> ans = new ArrayList<>();
    dfs(ans, new ArrayList<>(), s, 0);
    return ans;
  }

  private void dfs(List<String> ans, List<Integer> pre, String s, int i) {
    if (pre.size() == 4 && i == s.length()) {
      StringBuilder sb = new StringBuilder();
      sb.append(pre.get(0));
      for (int j = 1; j < 4; j++) {
        sb.append(".").append(pre.get(j));
      }
      ans.add(sb.toString());
    } else if (pre.size() == 4 || i == s.length()) {
    } else {
      for (int len = 1; len <= 3 && i + len <= s.length(); len++) {
        String sub = s.substring(i, i + len);
        char c = sub.charAt(0);
        if (len >= 2 && c == '0') {
          break;
        }
        int x = Integer.parseInt(sub);
        if (x > 255) {
          break;
        }
        List<Integer> cur = new ArrayList<>(pre);
        cur.add(x);
        dfs(ans, cur, s, i + len);
      }
    }
  }

  public List<String> restoreIpAddresses2(String s) {
    List<String> ans = new ArrayList<>();
    backtracking(ans, new ArrayList<>(), s, 0);
    return ans;
  }

  private void backtracking(List<String> ans, List<Integer> list, String s, int i) {
    if (list.size() == 4 && i == s.length()) {
      StringBuilder sb = new StringBuilder();
      sb.append(list.get(0));
      for (int j = 1; j < 4; j++) {
        sb.append(".").append(list.get(j));
      }
      ans.add(sb.toString());
    } else if (list.size() == 4 || i == s.length()) {
    } else {
      for (int len = 1; len <= 3 && i + len <= s.length(); len++) {
        String sub = s.substring(i, i + len);
        char c = sub.charAt(0);
        if (len >= 2 && c == '0') {
          break;
        }
        int x = Integer.parseInt(sub);
        if (x > 255) {
          break;
        }
        list.add(x);
        backtracking(ans, list, s, i + len);
        list.remove(list.size() - 1);
      }
    }
  }
}
