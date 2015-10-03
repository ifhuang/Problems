package leetcode.algorithms;

// https://oj.leetcode.com/problems/count-and-say/
public class CountandSay {
  // recursive
  public String countAndSay(int n) {
    if (n == 1) {
      return "1";
    }
    String pre = countAndSay(n - 1);
    StringBuilder sb = new StringBuilder();
    char[] c = pre.toCharArray();
    char p = c[0];
    int count = 1;
    for (int i = 1; i < c.length; i++) {
      if (c[i] == p) {
        count++;
      } else {
        sb.append(count).append(p);
        p = c[i];
        count = 1;
      }
    }
    sb.append(count).append(p);
    return sb.toString();
  }

  // iterative
  public String countAndSay2(int n) {
    int i = 1;
    String s = "1";
    while (i++ < n) {
      char[] c = s.toCharArray();
      char p = c[0];
      int count = 1;
      StringBuilder sb = new StringBuilder();
      for (int j = 1; j < c.length; j++) {
        if (c[j] == p) {
          count++;
        } else {
          sb.append(count).append(p);
          p = c[j];
          count = 1;
        }
      }
      sb.append(count).append(p);
      s = sb.toString();
    }
    return s;
  }
}
