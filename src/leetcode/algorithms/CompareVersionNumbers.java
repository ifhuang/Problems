package leetcode.algorithms;

// https://leetcode.com/problems/compare-version-numbers/
public class CompareVersionNumbers {
  public int compareVersion(String version1, String version2) {
    String[] p1 = version1.split("\\.");
    int n1 = p1.length;
    String[] p2 = version2.split("\\.");
    int n2 = p2.length;
    for (int i = 0; i < Math.max(n1, n2); i++) {
      int v1 = i < n1 ? Integer.parseInt(p1[i]) : 0;
      int v2 = i < n2 ? Integer.parseInt(p2[i]) : 0;
      if (v1 > v2) {
        return 1;
      } else if (v1 < v2) {
        return -1;
      }
    }
    return 0;
  }
}
