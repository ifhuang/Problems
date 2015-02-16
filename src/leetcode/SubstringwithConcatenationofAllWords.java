package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://oj.leetcode.com/problems/substring-with-concatenation-of-all-words/
public class SubstringwithConcatenationofAllWords {
  public List<Integer> findSubstring(String S, String[] L) {
    List<Integer> list = new ArrayList<>();
    int a = L[0].length();
    int n = a * L.length;
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < L.length; i++)
      if (map.containsKey(L[i]))
        map.put(L[i], map.get(L[i]) + 1);
      else
        map.put(L[i], 1);
    for (int i = 0; i < S.length() - n + 1; i++) {
      Map<String, Integer> tmpMap = new HashMap<>(map);
      for (int j = i; j < i + n; j += a) {
        String sub = S.substring(j, j + a);
        if (tmpMap.containsKey(sub) && tmpMap.get(sub) > 1)
          tmpMap.put(sub, tmpMap.get(sub) - 1);
        else if (tmpMap.containsKey(sub) && tmpMap.get(sub) == 1)
          tmpMap.remove(sub);
        else
          break;
      }
      if (tmpMap.isEmpty())
        list.add(i);
    }
    return list;
  }
}
