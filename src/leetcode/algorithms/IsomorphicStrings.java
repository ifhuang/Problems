package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
  public boolean isIsomorphic(String s, String t) {
    Map<Character, Character> from = new HashMap<>();
    Map<Character, Character> to = new HashMap<>();
    char[] sc = s.toCharArray();
    char[] tc = t.toCharArray();
    for (int i = 0; i < sc.length; i++)
      if (from.containsKey(sc[i])) {
        if (from.get(sc[i]) != tc[i])
          return false;
      } else if (to.containsKey(tc[i]))
        return false;
      else {
        from.put(sc[i], tc[i]);
        to.put(tc[i], sc[i]);
      }
    return true;
  }
}
