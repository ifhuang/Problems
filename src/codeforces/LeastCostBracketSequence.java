package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;

public class LeastCostBracketSequence {

  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    StringBuilder pattern = new StringBuilder(in.readLine());
    long cost = 0;
    int state = 0;
    PriorityQueue<Bracket> pq = new PriorityQueue<>();
    for (int i = 0; i < pattern.length(); i++) {
      char c = pattern.charAt(i);
      if (c == '(')
        state++;
      else if (c == ')')
        state--;
      else {
        String line = in.readLine();
        String[] part = line.split(" ");
        int open = Integer.parseInt(part[0]);
        int close = Integer.parseInt(part[1]);
        pq.add(new Bracket(i, close - open));
        pattern.setCharAt(i, ')');
        state--;
        cost += close;
      }
      if (state < 0) {
        if (pq.isEmpty())
          break;
        Bracket b = pq.poll();
        pattern.setCharAt(b.index, '(');
        state += 2;
        cost -= b.diff;
      }
    }
    if (state != 0) {
      cost = -1;
      pattern = new StringBuilder();
    }
    out.println(cost);
    out.println(pattern.toString());
    out.close();
    in.close();
  }
}


class Bracket implements Comparable<Bracket> {

  int index;
  int diff;

  public Bracket(int index, int diff) {
    this.index = index;
    this.diff = diff;
  }

  @Override
  public int compareTo(Bracket o) {
    return o.diff - this.diff;
  }

}
