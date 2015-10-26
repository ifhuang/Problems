package leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/repeated-dna-sequences/
public class RepeatedDNASequences {
  public List<String> findRepeatedDnaSequences(String s) {
    Map<Integer, Boolean> map = new HashMap<>();
    List<String> ans = new ArrayList<>();
    for (int i = 0; i + 10 <= s.length(); i++) {
      int num = 0;
      for (int j = i; j < i + 10; j++) {
        num = (num << 2) | "ATCG".indexOf(s.charAt(j));
      }
      if (map.containsKey(num)) {
        boolean val = map.get(num);
        if (val) {
          ans.add(s.substring(i, i + 10));
          map.put(num, false);
        }
      } else {
        map.put(num, true);
      }
    }
    return ans;
  }
}
