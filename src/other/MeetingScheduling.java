package other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MeetingScheduling {


  public List<Interval> findScheduling(List<Interval> list) {
    Collections.sort(list, new Comparator<Interval>() {
      @Override
      public int compare(Interval o1, Interval o2) {
        return o1.s == o2.s ? o1.e - o2.e : o1.s - o2.s;
      }
    });
    List<Interval> ans = new LinkedList<>();
    int n = list.size();
    if (n == 0) {
      return ans;
    }
    ans.add(0, list.get(n - 1));
    for (int i = n - 2; i >= 0; i--) {
      Interval cur = list.get(i);
      Interval pre = ans.get(ans.size() - 1);
      if (pre.s > cur.e) {
        ans.add(0, cur);
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    List<Interval> list = new ArrayList<>();
    list.add(new Interval(0, 1));
    list.add(new Interval(0, 2));
    list.add(new Interval(1, 3));
    list.add(new Interval(-2, -1));
    MeetingScheduling ms = new MeetingScheduling();
    System.out.println(ms.findScheduling(list));
  }
}


class Interval {
  int s, e;

  public Interval(int s, int e) {
    this.s = s;
    this.e = e;
  }

  @Override
  public String toString() {
    return "Interval [s=" + s + ", e=" + e + "]";
  }

}
