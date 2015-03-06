package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmrandMusic {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String[] part = in.readLine().split(" ");
    int k = Integer.parseInt(part[1]);
    part = in.readLine().split(" ");
    List<Instrument> list = new ArrayList<>();
    for (int i = 0; i < part.length; i++)
      list.add(new Instrument(i + 1, Integer.parseInt(part[i])));
    Collections.sort(list);
    List<Integer> ans = new ArrayList<>();
    for (Instrument i : list)
      if (k >= i.day) {
        ans.add(i.index);
        k -= i.day;
      } else
        break;
    out.println(ans.size());
    for (int i : ans) {
      out.print(i);
      out.print(' ');
    }
    out.close();
    in.close();
  }
}


class Instrument implements Comparable<Instrument> {
  int index;
  int day;

  Instrument(int i, int d) {
    index = i;
    day = d;
  }

  @Override
  public int compareTo(Instrument o) {
    return day - o.day;
  }

}
