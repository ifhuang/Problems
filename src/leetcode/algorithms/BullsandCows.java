package leetcode.algorithms;

// https://leetcode.com/problems/bulls-and-cows/
public class BullsandCows {
  public String getHint(String secret, String guess) {
    int n = secret.length();
    int len = 10;
    int[] count = new int[len];
    int cA = 0;
    int cB = 0;
    for (int i = 0; i < n; i++) {
      int a = secret.charAt(i) - '0';
      int b = guess.charAt(i) - '0';
      if (a == b) {
        cA++;
      } else {
        if (count[a] < 0) {
          cB++;
        }
        if (count[b] > 0) {
          cB++;
        }
        count[a]++;
        count[b]--;
      }
    }
    return cA + "A" + cB + "B";
  }
}
