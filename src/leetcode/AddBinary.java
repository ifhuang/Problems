package leetcode;

// https://oj.leetcode.com/problems/add-binary/
public class AddBinary {
  public String addBinary(String a, String b) {
    int la = a.length();
    int lb = b.length();
    if (la < lb)
      return addBinary(b, a);
    StringBuilder sb = new StringBuilder();
    for (; lb < la; lb++)
      sb.append('0');
    sb.append(b);
    b = sb.toString();
    int flag = 0;
    sb = new StringBuilder();
    for (int i = la - 1; i >= 0; i--) {
      int num =
          Character.getNumericValue(a.charAt(i)) + Character.getNumericValue(b.charAt(i)) + flag;
      sb.insert(0, num % 2);
      flag = num / 2;
    }
    if (flag == 1)
      sb.insert(0, 1);
    return sb.toString();
  }
}
