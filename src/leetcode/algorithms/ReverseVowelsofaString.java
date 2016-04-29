package leetcode.algorithms;

// https://leetcode.com/problems/reverse-vowels-of-a-string/
public class ReverseVowelsofaString {
  public String reverseVowels(String s) {
    StringBuilder sb = new StringBuilder();
    int n = s.length();
    int p = n;
    for (int i = 0; i < n; i++) {
      if (isVowel(s.charAt(i))) {
        p--;
        while (p >= 0 && !isVowel(s.charAt(p))) {
          p--;
        }
        sb.append(s.charAt(p));
      } else {
        sb.append(s.charAt(i));
      }
    }
    return sb.toString();
  }

  private boolean isVowel(char c) {
    return "aeiouAEIOU".indexOf(c) >= 0;
  }
}
