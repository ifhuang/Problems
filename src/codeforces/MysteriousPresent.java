package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MysteriousPresent {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line = in.readLine();
    String[] part = line.split(" ");
    int n = Integer.parseInt(part[0]);
    int w = Integer.parseInt(part[1]);
    int h = Integer.parseInt(part[2]);
    List<Envelope> list = new ArrayList<>();
    Envelope root = new Envelope(0, w, h);
    list.add(root);
    for (int i = 1; i <= n; i++) {
      line = in.readLine();
      part = line.split(" ");
      w = Integer.parseInt(part[0]);
      h = Integer.parseInt(part[1]);
      if (w > root.w && h > root.h)
        list.add(new Envelope(i, w, h));
    }
    Collections.sort(list);
    int len = list.size();
    int[] dp = new int[len];
    int[] pre = new int[len];
    int max = 0;
    int maxIndex = -1;
    for (int i = 1; i < len; i++)
      for (int j = 0; j < i; j++) {
        Envelope ej = list.get(j);
        Envelope ei = list.get(i);
        if (ej.w < ei.w && ej.h < ei.h && dp[j] + 1 > dp[i]) {
          dp[i] = dp[j] + 1;
          pre[i] = j;
          if (dp[i] > max) {
            max = dp[i];
            maxIndex = i;
          }
        }
      }

    out.println(max);
    if (max != 0) {
      StringBuilder sb = new StringBuilder();
      sb.insert(0, list.get(maxIndex).index);
      while (true) {
        maxIndex = pre[maxIndex];
        if (maxIndex == 0)
          break;
        sb.insert(0, ' ');
        sb.insert(0, list.get(maxIndex).index);
      }
      out.println(sb.toString());
    }
    out.close();
    in.close();
  }
}


class Envelope implements Comparable<Envelope> {

  int index;
  int w;
  int h;

  public Envelope(int index, int w, int h) {
    this.index = index;
    this.w = w;
    this.h = h;
  }

  @Override
  public int compareTo(Envelope o) {
    return this.w == o.w ? this.h - o.h : this.w - o.w;
  }

  @Override
  public String toString() {
    return "Envelope [index=" + index + ", w=" + w + ", h=" + h + "]";
  }

}
