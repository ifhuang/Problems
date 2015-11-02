package lintcode;

// http://www.lintcode.com/en/problem/compare-strings/
public class CompareStrings {
  /**
   * @param A : A string includes Upper Case letters
   * @param B : A string includes Upper Case letter
   * @return : if string A contains all of the characters in B return true else return false
   */
  public boolean compareStrings(String A, String B) {
    // write your code here
    int len = 26;
    int[] count = new int[len];
    for (int i = 0; i < A.length() || i < B.length(); i++) {
      if (i < A.length()) {
        count[A.charAt(i) - 'A']++;
      }
      if (i < B.length()) {
        count[B.charAt(i) - 'A']--;
      }
    }
    for (int i = 0; i < len; i++) {
      if (count[i] < 0) {
        return false;
      }
    }
    return true;
  }
}
