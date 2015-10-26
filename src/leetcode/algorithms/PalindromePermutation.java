package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/palindrome-permutation/
// Given a string, determine if a permutation of the string could form a palindrome.
// For example,
// "code" -> False, "aab" -> True, "carerac" -> True.
// Hint:
// Consider the palindromes of odd vs even length. What difference do you notice?
// Count the frequency of each character.
// If each character occurs even number of times, then it must be a palindrome. How about character
// which occurs odd number of times?
public class PalindromePermutation {
  public boolean canPermutePalindrome(String s) {
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!set.contains(c)) {
        set.add(c);
      } else {
        set.remove(c);
      }
    }
    return set.size() <= 1;
  }
}
