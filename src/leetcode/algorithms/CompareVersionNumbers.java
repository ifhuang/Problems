package leetcode.algorithms;

public class CompareVersionNumbers {
  public int compareVersion(String version1, String version2) {
    int[] num1 = helper1(version1.split("\\."));
    int[] num2 = helper1(version2.split("\\."));
    int e1 = helper2(num1);
    int e2 = helper2(num2);
    for (int i1 = 0, i2 = 0;;)
      if (i1 > e1 && i2 > e2)
        return 0;
      else if (i1 > e1)
        return -1;
      else if (i2 > e2)
        return 1;
      else if (num1[i1] != num2[i2])
        return num1[i1] > num2[i2] ? 1 : -1;
      else {
        i1++;
        i2++;
      }
  }

  private static int[] helper1(String[] part) {
    int n = part.length;
    int[] num = new int[n];
    for (int i = 0; i < n; i++)
      num[i] = Integer.parseInt(part[i]);
    return num;
  }

  private static int helper2(int[] num) {
    int e = num.length - 1;
    while (e > 0)
      if (num[e] == 0)
        e--;
      else
        break;
    return e;
  }
}
