package leetcode.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/unique-word-abbreviation/
// An abbreviation of a word follows the form <first letter><number><last letter>. Below are some
// examples of word abbreviations:
// a) it --> it (no abbreviation)
// b) d|o|g --> d1g
// c) i|nternationalizatio|n --> i18n
// d) l|ocalizatio|n --> l10n
// Assume you have a dictionary and given a word, find whether its abbreviation is unique in the
// dictionary. A word's abbreviation is unique if no other word from the dictionary has the same
// abbreviation.
// Example:
// Given dictionary = [ "deer", "door", "cake", "card" ]
// isUnique("dear") -> false
// isUnique("cart") -> true
// isUnique("cane") -> false
// isUnique("make") -> true
public class UniqueWordAbbreviation {
  private Map<String, Set<String>> map = new HashMap<>();

  public UniqueWordAbbreviation(String[] dictionary) {
    // build the hashmap
    // the key is the abbreviation
    // the value is a hash set of the words that have the same abbreviation
    for (String d : dictionary) {
      String a = abbr(d);
      Set<String> set = map.containsKey(a) ? map.get(a) : new HashSet<>();
      set.add(d);
      map.put(a, set);
    }
  }

  public boolean isUnique(String word) {
    String a = abbr(word);
    // it's unique when the abbreviation does not exist in the map or
    // it's the only word in the set
    return !map.containsKey(a) || (map.get(a).contains(word) && map.get(a).size() == 1);
  }

  private String abbr(String s) {
    return s.length() < 3 ? s : s.substring(0, 1) + String.valueOf(s.length() - 2)
        + s.substring(s.length() - 1);
  }
}
