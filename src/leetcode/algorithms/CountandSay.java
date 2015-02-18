package leetcode.algorithms;

// https://oj.leetcode.com/problems/count-and-say/
public class CountandSay {
  public String countAndSay(int n) {
    if (n == 1)
      return "1";
    String pre = countAndSay(n - 1);
    int count = 1;
    char now = pre.charAt(0);
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < pre.length(); i++) {
      char c = pre.charAt(i);
      if (c == pre.charAt(i - 1))
        count++;
      else {
        sb.append(count).append(now);
        count = 1;
        now = c;
      }
    }
    sb.append(count).append(now);
    return sb.toString();
  }
}
