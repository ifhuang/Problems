package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class BeforeanExam {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line = in.readLine();
    String[] part = line.split(" ");
    int d = Integer.parseInt(part[0]);
    int sumTime = Integer.parseInt(part[1]);
    int sum = 0;
    List<Schedual> list = new ArrayList<>();
    for (int i = 0; i < d; i++) {
      line = in.readLine();
      part = line.split(" ");
      int min = Integer.parseInt(part[0]);
      int max = Integer.parseInt(part[1]);
      sum += min;
      if (sum > sumTime)
        break;
      list.add(new Schedual(min, max, min));
    }
    if (sum < sumTime)
      for (Schedual s : list) {
        int add = Math.min(s.max - s.now, sumTime - sum);
        s.now += add;
        sum += add;
        if (sum == add)
          break;
      }
    if (sum == sumTime) {
      out.println("YES");
      out.print(list.get(0).now);
      for (int i = 1; i < d; i++)
        out.print(" " + list.get(i).now);
      out.println();
    } else
      out.println("NO");
    out.close();
    in.close();
  }
}


class Schedual {
  int min;
  int max;
  int now;

  public Schedual(int min, int max, int now) {
    this.min = min;
    this.max = max;
    this.now = now;
  }
}
