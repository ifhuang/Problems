package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

// https://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinationsofaPhoneNumber {
  private static String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  public List<String> letterCombinations(String digits) {
    List<String> list = new ArrayList<>();
    if (digits.length() == 0) {
      list.add("");
      return list;
    }
    String letters = map[digits.charAt(0) - '0'];
    List<String> postList = letterCombinations(digits.substring(1));
    if (letters.length() == 0)
      return postList;
    for (int i = 0; i < letters.length(); i++)
      for (String s : postList)
        list.add(letters.charAt(i) + s);
    return list;
  }
}
