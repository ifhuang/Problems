package other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicates {
  public List<Integer> find(int[] a) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < a.length; i++) {
      int index = Math.abs(a[i]);
      if (a[index] < 0) {
        set.add(index);
      } else {
        a[index] = -a[index];
      }
    }
    for (int i = 0; i < a.length; i++) {
      if (a[i] < 0) {
        a[i] = Math.abs(a[i]);
      }
    }
    return new ArrayList<>(set);
  }
}
