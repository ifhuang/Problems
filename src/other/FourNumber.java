package other;

import java.util.ArrayList;
import java.util.List;

public class FourNumber {
  public long convert(long input) {
    List<Integer> list = new ArrayList<>();
    while (input != 0) {
      list.add((int) (input % 9));
      input /= 9;
    }
    int[] num = {0, 1, 2, 3, 5, 6, 7, 8, 9};
    long ans = 0;
    for (int j = list.size() - 1; j >= 0; j--) {
      ans = ans * 10 + num[list.get(j)];
    }
    return ans;
  }

  public static void main(String[] args) {
    FourNumber f = new FourNumber();
    System.out.println(344 + " " + f.convert(344));
  }
}
