package leetcode.algorithms;

// https://oj.leetcode.com/problems/valid-number/
public class ValidNumber {
  public boolean isNumber(String s) {
    int start = 0;
    int len = s.length();
    while (start < len && s.charAt(start) == ' ')
      start++;
    if (start == len)
      return false;
    if (s.charAt(start) == '-' || s.charAt(start) == '+')
      start++;
    if (start == len)
      return false;
    int end = len - 1;
    while (end >= 0 && s.charAt(end) == ' ')
      end--;
    return eDotNum(s.substring(start, end + 1));
  }

  private boolean eDotNum(String s) {
    if (s.equals("e"))
      return false;
    int e = s.indexOf("e");
    int len = s.length();
    if (e < 0)
      return dotNum(s);
    else if (e == 0 || e == len - 1)
      return false;
    else if (s.charAt(e + 1) == '-' || s.charAt(e + 1) == '+')
      if (e + 1 == len - 1)
        return false;
      else
        return dotNum(s.substring(0, e)) && num(s.substring(e + 2, len));
    else
      return dotNum(s.substring(0, e)) && num(s.substring(e + 1, len));

  }

  private boolean dotNum(String s) {
    if (s.equals("."))
      return false;
    int dot = s.indexOf(".");
    if (dot < 0)
      return num(s);
    else
      return num(s.substring(0, dot)) && num(s.substring(dot + 1, s.length()));
  }

  private boolean num(String s) {
    for (int i = 0; i < s.length(); i++)
      if (!Character.isDigit(s.charAt(i)))
        return false;
    return true;
  }
}
