package leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {
  public List<String> findRepeatedDnaSequences(String s) {
    Set<Integer> set1 = new HashSet<>();
    Set<Integer> set2 = new HashSet<>();
    List<String> ans = new ArrayList<>();
    for (int i = 0; i + 10 <= s.length(); i++) {
      int num = 0;
      for (int j = i; j < i + 10; j++)
        num = num << 2 | "ATCG".indexOf(s.charAt(j));
      if (!set1.add(num) && set2.add(num))
        ans.add(s.substring(i, i + 10));
    }
    return ans;
  }
}
